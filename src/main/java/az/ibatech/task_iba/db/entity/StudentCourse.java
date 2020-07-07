/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.ibatech.task_iba.db.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author heisenberg
 */
@Entity
@Table(name = "StudentCourse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentCourse.findAll", query = "SELECT s FROM StudentCourse s")
    , @NamedQuery(name = "StudentCourse.findByIdStudentCourse", query = "SELECT s FROM StudentCourse s WHERE s.idStudentCourse = :idStudentCourse")
    , @NamedQuery(name = "StudentCourse.findByStart", query = "SELECT s FROM StudentCourse s WHERE s.start = :start")
    , @NamedQuery(name = "StudentCourse.findByFinish", query = "SELECT s FROM StudentCourse s WHERE s.finish = :finish")})
public class StudentCourse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_student_course")
    private Integer idStudentCourse;
    @Column(name = "start")
    @Temporal(TemporalType.DATE)
    private Date start;
    @Column(name = "finish")
    @Temporal(TemporalType.DATE)
    private Date finish;
    @JoinColumn(name = "id_course", referencedColumnName = "id_course")
    @ManyToOne(fetch = FetchType.EAGER)
    private Course idCourse;
    @JoinColumn(name = "id_student", referencedColumnName = "id_student")
    @ManyToOne(fetch = FetchType.EAGER)
    private Student idStudent;

    public StudentCourse() {
    }

    public StudentCourse(Integer idStudentCourse) {
        this.idStudentCourse = idStudentCourse;
    }

    public Integer getIdStudentCourse() {
        return idStudentCourse;
    }

    public void setIdStudentCourse(Integer idStudentCourse) {
        this.idStudentCourse = idStudentCourse;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getFinish() {
        return finish;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }

    public Course getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Course idCourse) {
        this.idCourse = idCourse;
    }

    public Student getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Student idStudent) {
        this.idStudent = idStudent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStudentCourse != null ? idStudentCourse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentCourse)) {
            return false;
        }
        StudentCourse other = (StudentCourse) object;
        if ((this.idStudentCourse == null && other.idStudentCourse != null) || (this.idStudentCourse != null && !this.idStudentCourse.equals(other.idStudentCourse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.StudentCourse[ idStudentCourse=" + idStudentCourse + " ]";
    }
    
}
