package com.instantsystem.bordeaux.lacub.model;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    /**
     * Create an instance of of {@link ObjectFactory }
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BoundedBy }
     *
     */
    public BoundedBy createBoundedBy() {
        return new BoundedBy();
    }

    /**
     * Create an instance of {@link STPARKP }
     *
     */
    public STPARKP createSTPARKP() {
        return new STPARKP();
    }

    /**
     * Create an instance of {@link FeatureCollection }
     *
     */
    public FeatureCollection createFeatureCollection() {
        return new FeatureCollection();
    }

    /**
     * Create an instance of {@link BoundedBy.Envelope }
     *
     */
    public BoundedBy.Envelope createBoundedByEnvelope() {
        return new BoundedBy.Envelope();
    }

    /**
     * Create an instance of {@link FeatureMember }
     *
     */
    public FeatureMember createFeatureMember() {
        return new FeatureMember();
    }

    /**
     * Create an instance of {@link STPARKP.Geometry }
     *
     */
    public STPARKP.Geometry createSTPARKPGeometry() {
        return new STPARKP.Geometry();
    }

    /**
     * Create an instance of {@link Point }
     *
     */
    public Point createPoint() {
        return new Point();
    }

}
