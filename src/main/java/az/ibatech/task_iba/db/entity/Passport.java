/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.ibatech.task_iba.db.entity;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Susan Yunusova
 */
@Entity
@Data
@Table(name = "Passport")
public class Passport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_passport")
    private Integer idPassport;
    @Column(name = "pincode")
    private String pincode;
    @Column(name = "serial")
    private String serial;
    @Column(name = "isActive")
    private Integer isActive;
    @JoinColumn(name = "id_student", referencedColumnName = "id_student")
    @ManyToOne(fetch = FetchType.EAGER)
    private Student idStudent;


}
