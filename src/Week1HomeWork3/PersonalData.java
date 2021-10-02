package Week1HomeWork3;

import java.time.LocalDate;

public class PersonalData {
    private LocalDate birthDate;
    private String address;
    private long ssn;

    public PersonalData(LocalDate birthDate, long ssn) {
        setBirthDate(birthDate);
        setSsn(ssn);
    }

    public PersonalData(int year, int month, int day, long ssn) {
        this.birthDate = LocalDate.of(year, month, day);
        this.ssn = ssn;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getSsn() {
        return ssn;
    }

    public void setSsn(long ssn) {
        this.ssn = ssn;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
