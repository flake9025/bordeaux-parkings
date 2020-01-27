package com.instantsystem.bordeaux.lacub.model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement(name = "FeatureCollection")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeatureCollection {

    @XmlElement(name = "boundedBy")
    private BoundedBy boundedBy;
    @XmlElement(name = "featureMember")
    private List<FeatureMember> featureMember;
}
