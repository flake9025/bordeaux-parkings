package com.instantsystem.bordeaux.lacub.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement(name = "STPARKP", namespace = "http://data.bordeaux-metropole.fr/wfs")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class STPARKP {

    @XmlElement
    private BoundedBy boundedBy;
    @XmlElement
    private STPARKP.Geometry geometry;
    @XmlElement(name = "GID")
    private int gid;
    @XmlElement(name = "IDENT")
    private String ident;
    @XmlElement(name = "NOM")
    private String nom;
    @XmlElement(name = "LIBRES")
    private String libres;
    @XmlElement(name = "TOTAL")
    private String total;
    @XmlElement(name = "PREPAYE")
    private String prepaye;
    @XmlElement(name = "ETAT")
    private String etat;
    @XmlElement(name = "CONNECTE")
    private String connecte;
    @XmlElement(name = "URL")
    private String url;
    @XmlElement(name = "TA_TITUL")
    private String tatitul;
    @XmlElement(name = "TA_NTITUL")
    private String tantitul;
    @XmlElement(name = "TH_QUAR")
    private String thquar;
    @XmlElement(name = "TH_DEMI")
    private String thdemi;
    @XmlElement(name = "TH_HEUR")
    private String thheur;
    @XmlElement(name = "TH_2")
    private String th2;
    @XmlElement(name = "TH_3")
    private String th3;
    @XmlElement(name = "TH_4")
    private String th4;
    @XmlElement(name = "TH_10")
    private String th10;
    @XmlElement(name = "TH_24")
    private String th24;
    @XmlElement(name = "TH_NUIT")
    private String thnuit;
    @XmlElement(name = "TA_RESMOI")
    private String taresmoi;
    @XmlElement(name = "TA_NRES7J")
    private String tanres7J;
    @XmlElement(name = "TA_MOIMOT")
    private String tamoimot;
    @XmlElement(name = "TA_MOIVEL")
    private String tamoivel;
    @XmlElement(name = "TV_1H")
    private String tv1H;
    @XmlElement(name = "INFOR")
    private String infor;
    @XmlElement(name = "PROPR")
    private String propr;
    @XmlElement(name = "TITUL")
    private String titul;
    @XmlElement(name = "EXPLOIT")
    private String exploit;
    @XmlElement(name = "TYPGEST")
    private String typgest;
    @XmlElement(name = "SECTEUR")
    private String secteur;
    @XmlElement(name = "INSEE")
    @XmlSchemaType(name = "unsignedShort")
    private int insee;
    @XmlElement(name = "AN_SERV")
    @XmlSchemaType(name = "unsignedShort")
    private int anserv;
    @XmlElement(name = "TYPE")
    private String type;
    @XmlElement(name = "NB_NIV")
    @XmlSchemaType(name = "unsignedByte")
    private short nbniv;
    @XmlElement(name = "NP_HGINF")
    @XmlSchemaType(name = "unsignedByte")
    private short nphginf;
    @XmlElement(name = "NP_HGSUP")
    @XmlSchemaType(name = "unsignedByte")
    private short nphgsup;
    @XmlElement(name = "NP_FOURR")
    @XmlSchemaType(name = "unsignedByte")
    private short npfourr;
    @XmlElement(name = "NP_GLOBAL")
    @XmlSchemaType(name = "unsignedShort")
    private int npglobal;
    @XmlElement(name = "NP_TOTAL")
    @XmlSchemaType(name = "unsignedShort")
    private int nptotal;
    @XmlElement(name = "NP_PR")
    @XmlSchemaType(name = "unsignedShort")
    private int nppr;
    @XmlElement(name = "NP_PMR")
    @XmlSchemaType(name = "unsignedByte")
    private short nppmr;
    @XmlElement(name = "NP_VLE")
    @XmlSchemaType(name = "unsignedByte")
    private short npvle;
    @XmlElement(name = "NP_MOBALT")
    @XmlSchemaType(name = "unsignedByte")
    private short npmobalt;
    @XmlElement(name = "NP_COVOIT")
    @XmlSchemaType(name = "unsignedByte")
    private short npcovoit;
    @XmlElement(name = "NP_STLAV")
    @XmlSchemaType(name = "unsignedByte")
    private short npstlav;
    @XmlElement(name = "NP_2RMOT")
    @XmlSchemaType(name = "unsignedByte")
    private short np2RMOT;
    @XmlElement(name = "NP_2RELE")
    @XmlSchemaType(name = "unsignedByte")
    private short np2RELE;
    @XmlElement(name = "NP_VELTOT")
    @XmlSchemaType(name = "unsignedByte")
    private short npveltot;
    @XmlElement(name = "NP_VELEC")
    @XmlSchemaType(name = "unsignedByte")
    private short npvelec;
    @XmlElement(name = "ADRESSE")
    private String adresse;
    @XmlElement(name = "GABARI_MAX")
    private String gabarimax;
    @XmlElement(name = "GABARI_STD")
    private String gabaristd;
    @XmlElement(name = "TA_TYPE")
    private String tatype;
    @XmlElement(name = "TA_HANDI")
    private String tahandi;
    @XmlElement(name = "CDATE")
    private String cdate;
    @XmlElement(name = "MDATE")
    private String mdate;
    @XmlAttribute(name = "id")
    private String id;

    @XmlAccessorType(XmlAccessType.FIELD)
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Geometry {

        @XmlElement(name = "Point")
        private Point point;
    }
}
