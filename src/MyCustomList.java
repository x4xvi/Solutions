import java.util.ArrayList;
import java.util.HashMap;

public class MyCustomList {
    private HashMap<Integer, Integer> value_to_index;
    private ArrayList<Integer> data;

    public MyCustomList() {
        this.value_to_index = new HashMap<>();
        this.data=new ArrayList<>();
    }
    public int add(int value){
        int index=data.size();
        if (!value_to_index.containsKey(value)){
            data.add(value);
            value_to_index.put(value,index);
            return index;
        }
        return -1;
    }
    public int get(int index){
        for (int val:value_to_index.values()){
            if (index==val){
                return data.get(index);
            }
        }
        return -1;
    }
    public boolean delete(int value){
        if (value_to_index.containsKey(value)){
            int index=value_to_index.get(value);
            value_to_index.remove(value);
            int array_last_index=data.size()-1;
            data.set(index, data.get(array_last_index));
            data.remove(array_last_index);
            value_to_index.put(data.get(index), index);

            return true;
        }
        return false;
    }
}
