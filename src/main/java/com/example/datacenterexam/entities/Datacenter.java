package com.example.datacenterexam.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Datacenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDs;

    private String region;

    @Temporal(TemporalType.DATE)
    private Date dateFabrication;

    private int capaciteDisque;
    private int espaceLibreDisque;

    @JsonIgnore
    @OneToMany(mappedBy = "datacenter", cascade = CascadeType.ALL)
    private List<VirtualMachine> virtualMachines; // Bidirectional with VirtualMachine
}
