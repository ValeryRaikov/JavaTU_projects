public class SickPatient extends Patient {
    private String epicrisis;
    private final boolean isSick;
    private int dayOfIllness;

    public SickPatient(String name, String address, String egn, String epicrisis, int dayOfIllness) {
        super(name, address, egn);
        this.epicrisis = epicrisis;
        this.dayOfIllness = dayOfIllness;
        this.isSick = true;
    }

    public String getEpicrisis() {
        return this.epicrisis;
    }

    public void setEpicrisis() {
        this.epicrisis = epicrisis;
    }

    public int getDayOfIllness() {
        return this.dayOfIllness;
    }

    public void setDayOfIllness() {
        this.dayOfIllness = dayOfIllness;
    }

    public boolean getIsSick() {
        return this.isSick;
    }

    public void setIsSick() {
        if (!this.isSick) {
            System.out.println("Sick patients are always sick!");
            System.exit(1);
        }
        this.epicrisis = epicrisis;
    }

    @Override
    public String cure(String medicine, int dosage) {
        return "\nMedicine: " + medicine + " - Dosage: " + dosage + " units";
    }

    @Override
    public String toString() {
        return "Sick patient: " + this.getName() + ", with epicrisis of: " + this.epicrisis + " is ill from " + this.dayOfIllness + " days!";
    }
}