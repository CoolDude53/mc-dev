package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NBTTagList extends NBTBase {

    private List a = new ArrayList();
    private byte b;

    public NBTTagList() {
        super("");
    }

    public NBTTagList(String s) {
        super(s);
    }

    void a(DataOutput dataoutput) {
        if (this.a.size() > 0) {
            this.b = ((NBTBase) this.a.get(0)).a();
        } else {
            this.b = 1;
        }

        dataoutput.writeByte(this.b);
        dataoutput.writeInt(this.a.size());

        for (int i = 0; i < this.a.size(); ++i) {
            ((NBTBase) this.a.get(i)).a(dataoutput);
        }
    }

    void a(DataInput datainput) {
        this.b = datainput.readByte();
        int i = datainput.readInt();

        this.a = new ArrayList();

        for (int j = 0; j < i; ++j) {
            NBTBase nbtbase = NBTBase.a(this.b, (String) null);

            nbtbase.a(datainput);
            this.a.add(nbtbase);
        }
    }

    public byte a() {
        return (byte) 9;
    }

    public String toString() {
        return "" + this.a.size() + " entries of type " + NBTBase.a(this.b);
    }

    public void a(NBTBase nbtbase) {
        this.b = nbtbase.a();
        this.a.add(nbtbase);
    }

    public NBTBase a(int i) {
        return (NBTBase) this.a.get(i);
    }

    public int d() {
        return this.a.size();
    }

    public NBTBase b() {
        NBTTagList nbttaglist = new NBTTagList(this.c());

        nbttaglist.b = this.b;
        Iterator iterator = this.a.iterator();

        while (iterator.hasNext()) {
            NBTBase nbtbase = (NBTBase) iterator.next();
            NBTBase nbtbase1 = nbtbase.b();

            nbttaglist.a.add(nbtbase1);
        }

        return nbttaglist;
    }

    public boolean equals(Object object) {
        if (super.equals(object)) {
            NBTTagList nbttaglist = (NBTTagList) object;

            if (this.b == nbttaglist.b) {
                return this.a.equals(nbttaglist.a);
            }
        }

        return false;
    }
}
