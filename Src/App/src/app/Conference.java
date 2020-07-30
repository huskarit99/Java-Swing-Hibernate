/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "conference", catalog = "conference_management_system", schema = "")
@NamedQueries({
    @NamedQuery(name = "Conference.findAll", query = "SELECT c FROM Conference c")
    , @NamedQuery(name = "Conference.findByConferenceId", query = "SELECT c FROM Conference c WHERE c.conferenceId = :conferenceId")
    , @NamedQuery(name = "Conference.findByPlaceId", query = "SELECT c FROM Conference c WHERE c.placeId = :placeId")
    , @NamedQuery(name = "Conference.findByConferenceName", query = "SELECT c FROM Conference c WHERE c.conferenceName = :conferenceName")
    , @NamedQuery(name = "Conference.findBySummaryDescription", query = "SELECT c FROM Conference c WHERE c.summaryDescription = :summaryDescription")
    , @NamedQuery(name = "Conference.findByDetailDescription", query = "SELECT c FROM Conference c WHERE c.detailDescription = :detailDescription")
    , @NamedQuery(name = "Conference.findByDateStart", query = "SELECT c FROM Conference c WHERE c.dateStart = :dateStart")
    , @NamedQuery(name = "Conference.findByDateEnd", query = "SELECT c FROM Conference c WHERE c.dateEnd = :dateEnd")})
public class Conference implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "conference_id")
    private Integer conferenceId;
    @Column(name = "place_id")
    private Integer placeId;
    @Basic(optional = false)
    @Column(name = "conferenceName")
    private String conferenceName;
    @Column(name = "summaryDescription")
    private String summaryDescription;
    @Column(name = "detailDescription")
    private String detailDescription;
    @Column(name = "dateStart")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateStart;
    @Column(name = "dateEnd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnd;

    public Conference() {
    }

    public Conference(Integer conferenceId) {
        this.conferenceId = conferenceId;
    }

    public Conference(Integer conferenceId, String conferenceName) {
        this.conferenceId = conferenceId;
        this.conferenceName = conferenceName;
    }

    public Integer getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(Integer conferenceId) {
        Integer oldConferenceId = this.conferenceId;
        this.conferenceId = conferenceId;
        changeSupport.firePropertyChange("conferenceId", oldConferenceId, conferenceId);
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        Integer oldPlaceId = this.placeId;
        this.placeId = placeId;
        changeSupport.firePropertyChange("placeId", oldPlaceId, placeId);
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        String oldConferenceName = this.conferenceName;
        this.conferenceName = conferenceName;
        changeSupport.firePropertyChange("conferenceName", oldConferenceName, conferenceName);
    }

    public String getSummaryDescription() {
        return summaryDescription;
    }

    public void setSummaryDescription(String summaryDescription) {
        String oldSummaryDescription = this.summaryDescription;
        this.summaryDescription = summaryDescription;
        changeSupport.firePropertyChange("summaryDescription", oldSummaryDescription, summaryDescription);
    }

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        String oldDetailDescription = this.detailDescription;
        this.detailDescription = detailDescription;
        changeSupport.firePropertyChange("detailDescription", oldDetailDescription, detailDescription);
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        Date oldDateStart = this.dateStart;
        this.dateStart = dateStart;
        changeSupport.firePropertyChange("dateStart", oldDateStart, dateStart);
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        Date oldDateEnd = this.dateEnd;
        this.dateEnd = dateEnd;
        changeSupport.firePropertyChange("dateEnd", oldDateEnd, dateEnd);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conferenceId != null ? conferenceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conference)) {
            return false;
        }
        Conference other = (Conference) object;
        if ((this.conferenceId == null && other.conferenceId != null) || (this.conferenceId != null && !this.conferenceId.equals(other.conferenceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.Conference[ conferenceId=" + conferenceId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
