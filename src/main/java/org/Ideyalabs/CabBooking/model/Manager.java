    package org.Ideyalabs.CabBooking.model;

    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.util.List;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    public class Manager {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int managerId;
        private  String managerName;
        private String managerEmail;
        private String managerPhone;
        //Here One Manager can assigned to the Many Drivers like D1,D2,B3....etc
        @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
        //List of the Drivers for particular Manager
        private List<Driver> drivers;
    }
