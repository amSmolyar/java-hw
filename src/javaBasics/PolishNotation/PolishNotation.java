package javaBasics.PolishNotation;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolishNotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String scanData = "";
        int error;

        List<String> dataArray = new ArrayList<>();
        Stack<String> operatorList = new Stack<>();
        Queue<String> allSymbolList = new ArrayDeque<>();

        Pattern pattern = Pattern.compile("(-?\\d+(\\.\\d+)?)|([+*-/^%()])");

        System.out.println("Привет!");
        while (true) {
            dataArray.clear();
            operatorList.clear();
            allSymbolList.clear();
            error = 0;

            System.out.println("\nВведите арифметическое выражение (доступны операторы (), +, -, *, /, ^, %).\nДля завершения работы введите 'end'");
            scanData = scan.nextLine();
            scanData = scanData.trim();

            if (scanData.equals("end"))
                break;

            //считанное выражение (преобразованное):
            scanData = scanData.replaceAll("^[+/*^%)]+|[-+/*^%(]+$", "");

            int cntLeftBracket = 0;
            int cntRightBracket = 0;
            Matcher matcher = pattern.matcher(scanData);
            while (matcher.find()) {
                String newSymbol = matcher.group();
                dataArray.add(newSymbol);

                if (newSymbol.equals("("))
                    cntLeftBracket++;
                else if (newSymbol.equals(")"))
                    cntRightBracket++;
            }
            rewriteUserExpression(dataArray);
            if (cntLeftBracket != cntRightBracket) {
                System.out.println("Скобки в выражении не парные");
                continue;
            }

            //формируем выражение в формате обратной польской записи:
            String prevMember = "";
            for (String member : dataArray) {
                // Проверяем, не забыли ли оператор между переменными:
                if ((member.matches("(-?\\d+(\\.\\d+)?)")) && (prevMember.matches("(-?\\d+(\\.\\d+)?)"))) {
                    System.out.println("Между переменными отсутствует оператор");
                    error = 1;
                    break;
                }
                prevMember = member;

                if (member.matches("(-?\\d+(\\.\\d+)?)"))
                    allSymbolList.offer(member);
                else {
                    if (getPriority(member) == -1) {
                        System.out.println("Оператор не анализируется программой");
                        error = 1;
                        break;
                    } else if (member.equals(")")) {
                        while (!operatorList.empty() && !operatorList.peek().equals("(")) {
                            allSymbolList.offer(operatorList.pop());
                        }
                        if (operatorList.empty()) {
                            System.out.println("Отсутствует левая скобка '('");
                            error = 1;
                            break;
                        } else
                            operatorList.pop();
                    } else if (operatorList.empty() || member.equals("(") || (getPriority(operatorList.peek()) < getPriority(member))) {
                        operatorList.push(member);
                    } else {
                        allSymbolList.offer(operatorList.pop());
                        operatorList.push(member);
                    }
                }
            }

            while (!operatorList.empty()) {
                String operator = operatorList.pop();
                if (!(operator.equals("(") || operator.equals(")")))
                    allSymbolList.offer(operator);
            }

            if (error == 0)
                writeFinalExpression(allSymbolList);
        }

        scan.close();
    }

    public static void writeFinalExpression(Queue<String> queue) {
        String member;
        System.out.println("Выражение в обратной польской записи:");
        while (queue.peek() != null) {
            member = queue.poll();
            System.out.print(member + " ");
        }
        System.out.println();
    }

    public static void rewriteUserExpression(List<String> list) {
        System.out.println("Считанное выражение:");
        for (String member : list) {
            System.out.print(member + " ");
        }
        System.out.println();
    }

    public static int getPriority(String operator) {
        int priority;
        switch (operator) {
            case ("("):
            case (")"):
                priority = 0;
                break;
            case ("+"):
            case ("-"):
                priority = 1;
                break;
            case ("*"):
            case ("/"):
            case ("%"):
                priority = 2;
                break;
            case ("^"):
                priority = 3;
                break;
            default:
                priority = -1;
                break;
        }
        return priority;
    }
}
