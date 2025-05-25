package interfaces;

public interface RealEstateOwnership {
    String getCadastralNumber();
    void setCadastralNumber(String cadastralNumber);
    String getAddress();
    void setAddress(String address);

    double calculateUtilityCost();
}
