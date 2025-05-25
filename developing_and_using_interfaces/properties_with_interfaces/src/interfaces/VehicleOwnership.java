package interfaces;

public interface VehicleOwnership {
    String getRegistrationNumber();
    void setRegistrationNumber(String registrationNumber);
    int getYear();
    void setYear(int year);

    double calculateMaintenanceCost();
}
