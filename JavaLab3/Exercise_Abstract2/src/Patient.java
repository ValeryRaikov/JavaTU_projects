public abstract class Patient {
    private String name;
    private String address;
    private String EGN;

    public Patient(String name, String address, String egn) {
        this.name = name;
        this.address = address;
        this.EGN = egn;
    }

    public abstract String cure(String medicine, int dosage);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEGN() {
        return EGN;
    }

    public void setEGN(String EGN) {
        this.EGN = EGN;
    }

    @Override
    abstract public String toString();
}