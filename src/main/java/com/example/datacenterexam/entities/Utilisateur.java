package com.example.datacenterexam.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    private String nomUser;
    private String prenomUser;
    private String login;
    private String pwd;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUser") // Foreign key in VirtualMachine table
    private List<VirtualMachine> virtualMachines; // Utilisateur has access to its VMs not the other way around
}
