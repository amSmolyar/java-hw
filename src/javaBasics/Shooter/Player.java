package javaBasics.Shooter;

public class Player {
    private Weapon[] weaponSlots;

    public Player() {
        weaponSlots = new Weapon[]{
                new Automate(),
                new GrenadeGun(),
                new MachineGun(),
                new Pistol(),
                new Slingshot(),
                new WaterGun()
        };
    }

    public int getSlotsCount() {
        return weaponSlots.length;
    }

    public void shootByWeapon(int slot) {
        int slotCount = this.getSlotsCount();
        if (slot >= slotCount) {
            System.out.println("User slot number is out of total number of slots. Try again!");
        } else {
            Weapon weapon = weaponSlots[slot];
            weapon.shot();
        }
    }
}
