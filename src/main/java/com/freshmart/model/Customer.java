package com.freshmart.model;

import com.freshmart.util.Validator;

/**
 * A registered customer. The NIC is the permanent identifier and cannot change; the other
 * details can be maintained from the profile screen. Every setter validates its input, so an
 * invalid Customer object cannot exist.
 */
public class Customer extends User {
    private static final long serialVersionUID = 1L;

    private final String nic;
    private String contactNumber;
    private String deliveryAddress;
    private String email;

    public Customer(String nic, String fullName, String contactNumber, String deliveryAddress,
                    String email, String plainPassword) {
        super(fullName, plainPassword);
        this.nic = Validator.nic(nic);
        setContactNumber(contactNumber);
        setDeliveryAddress(deliveryAddress);
        setEmail(email);
    }

    /** Customers are stored under their NIC, which never changes. */
    @Override
    public String getId() { return nic; }

    @Override
    public String getLoginId() { return email; }

    @Override
    public Role getRole() { return Role.CUSTOMER; }

    public String getNic() { return nic; }
    public String getContactNumber() { return contactNumber; }
    public String getDeliveryAddress() { return deliveryAddress; }
    public String getEmail() { return email; }

    public void setContactNumber(String contactNumber) { this.contactNumber = Validator.phone(contactNumber); }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = Validator.requireText(deliveryAddress, "Delivery address");
    }

    /** Uniqueness of the email is checked by CustomerService, which can see every customer. */
    public void setEmail(String email) { this.email = Validator.email(email); }
}
