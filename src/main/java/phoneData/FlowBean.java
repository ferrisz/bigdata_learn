package phoneData;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

//1实现writable方法
public class FlowBean implements Writable{

    private long upflow;
    private long downflow;
    private long sumflow;

    //必须要有空参构造，为了以后反射用
    public FlowBean() {
        super();
    }


    public FlowBean(long upflow, long downflow) {
        super();
        this.upflow = upflow;
        this.downflow = downflow;
        this.sumflow = upflow+downflow;
    }

    public void set(long upflow, long downflow) {
        this.upflow = upflow;
        this.downflow = downflow;
        this.sumflow = upflow+downflow;
    }
    //序列化的方法
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeLong(upflow);
        out.writeLong(downflow);
        out.writeLong(sumflow);

        //反序列化方法
        //注意序列化方法和反序列化方法顺序必须保持一致
    }
    @Override
    public void readFields(DataInput in) throws IOException {
        this.upflow=in.readLong();
        this.downflow=in.readLong();
        this.sumflow=in.readLong();
    }


    @Override
    public String toString() {
        return  upflow + "\t" + downflow + "\t" + sumflow;
    }



    public void setUpflow(long upflow) {
        this.upflow = upflow;
    }

    public long getUpflow() {
        return upflow;
    }

    public long getDownflow() {
        return downflow;
    }


    public void setDownflow(long downflow) {
        this.downflow = downflow;
    }


    public long getSumflow() {
        return sumflow;
    }


    public void setSumflow(long sumflow) {
        this.sumflow = sumflow;
    }


}
