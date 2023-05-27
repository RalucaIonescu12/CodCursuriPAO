package Externalizare;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

//Externalizarea obiectelor unei clase este condiționată de implementarea interfeței Externalizable:
public interface Externalizable extends Serializable
{
    public void writeExternal(ObjectOutput out) throws IOException;
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException;
}
