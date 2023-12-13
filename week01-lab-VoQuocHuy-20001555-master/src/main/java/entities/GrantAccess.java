package entities;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class GrantAccess {
    private Role role;
    private Account account;
    private Grant grant;
    private String note;
}
