package com.ibm.streamsx.iotf;

import java.io.IOException;
import java.io.Serializable;

import com.ibm.json.java.JSONObject;

/**
 * A device.
 *
 */
public class Device implements Serializable {
    
    public static final String TYPE_ID = "typeId";
    public static final String DEVICE_ID = "deviceId";
    
    private static final long serialVersionUID = 1L;
    
    private final String typeId;
    private final String id;
    
    public Device(String typeId, String id) {
        super();
        this.typeId = typeId;
        this.id = id;
    }
    
    /**
     * Get the device type identifier.
     * @return device type identifier.
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * Get the device identifier.
     * @return device identifier.
     */
    public String getId() {
        return id;
    }
    
    public JSONObject toJson() {
        JSONObject json = new JSONObject();       
        json.put(TYPE_ID, getTypeId());
        json.put(DEVICE_ID, getId());       
        return json;
    }
    
    @Override
    public String toString() {
        try {
            return toJson().serialize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((typeId == null) ? 0 : typeId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Device other = (Device) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (typeId == null) {
            if (other.typeId != null)
                return false;
        } else if (!typeId.equals(other.typeId))
            return false;
        return true;
    }
}
