package com.instantsystem.bordeaux.lacub.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoundedBy {

    @XmlElement(name = "Envelope")
    protected BoundedBy.Envelope envelope;

    @XmlAccessorType(XmlAccessType.FIELD)
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Envelope {

        @XmlElement
        protected String lowerCorner;
        @XmlElement
        protected String upperCorner;
        @XmlAttribute(name = "srsName")
        protected String srsName;
    }
}
