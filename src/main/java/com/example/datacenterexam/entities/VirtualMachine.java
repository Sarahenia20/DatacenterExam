package com.example.datacenterexam.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VirtualMachine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVm;

    private String os;
    private int tailleDisque;

    @Enumerated(EnumType.STRING)
    private Etat etat;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idDs", nullable = false)
    private Datacenter datacenter; // VirtualMachine references Datacenter Bidirectional with Datacenter
}
