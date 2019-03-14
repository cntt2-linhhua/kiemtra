package vn.edu.leading.kiemtra.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "sinhviens")
public class SinhvienModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String ten;

    private int tuoi;

    @NotEmpty
    @Column(name = "que_quan", nullable = false)
    private String queQuan;

}
