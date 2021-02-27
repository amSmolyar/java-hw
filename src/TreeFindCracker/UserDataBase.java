package TreeFindCracker;

import java.util.*;

public class UserDataBase {
    private Map<String, User> userDB;
    private Map<String, Set<String>> userIP;
    private Map<String,Integer> logMap;
    private Map<String,Integer> visiting;
    private int maxVisiting;

    public UserDataBase() {
        userDB = new TreeMap<>();
        userIP = new HashMap<>();
        logMap = new HashMap<>();
        visiting = new HashMap<>();
        maxVisiting = 0;
    }

    public int getMaxVisiting() {
        return maxVisiting;
    }

    public void addUserBD(User newUser) {
        if (!userDB.containsKey(newUser.getId()))
            userDB.put(newUser.getId(), newUser);
    }

    public void addUserIP(String id, String newIP) {
        if (!userIP.containsKey(id))
            userIP.put(id, new HashSet<>());

        userIP.put(id, userIP.get(id)).add(newIP);
    }

    public void addVisit(String ip) {
        if (logMap.containsKey(ip))
            logMap.put(ip, (logMap.get(ip) + 1));
        else
            logMap.put(ip, 1);
    }

    public void countVisitNumber() {
        String ipSoughtFor = "";
        String currentID = "";
        //цикл по logMap (по ip-адресам и числом посещений):
        for (Map.Entry<String,Integer> entry : logMap.entrySet()) {
            ipSoughtFor = entry.getKey();
            try {
                currentID = findIdByIp(ipSoughtFor);
                addUserVisit(currentID, entry.getValue());
            } catch (UserNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String findIdByIp(String ipSoughtFor) throws UserNotFoundException {
        String currentID = "";
        //цикл по userIP (проверяем, есть ли среди ip-адресов пользователей ip-адрес ipSoughtFor):
        for (Map.Entry<String, Set<String>> entryIP : userIP.entrySet()) {
            currentID = entryIP.getKey();
            //цикл по set-у ip-адресов конкретного пользователя:
            for (String ip : entryIP.getValue()) {
                if (ip.equals(ipSoughtFor)) {
                    return currentID;
                }
            }
        }
        throw new UserNotFoundException("Пользователь с ip-адресом" + ipSoughtFor + "не зарегистрирован в базе");
    }

    public void addUserVisit(String id, int cntVisit) {
        if (visiting.containsKey(id))
            visiting.put(id, (visiting.get(id) + cntVisit));
        else
            visiting.put(id, cntVisit);
    }

    public String findCrackerId() {
        String crackerId = "";
        maxVisiting = 0;
        countVisitNumber();
        for (Map.Entry<String,Integer> entry : visiting.entrySet()) {
            if (entry.getValue() >= maxVisiting) {
                crackerId = entry.getKey();
                maxVisiting = entry.getValue();
            }
        }
        return crackerId;
    }

    public User findUser(String id) {
        return userDB.get(id);
    }

}
