public class EmptyNode implements IListOfInts{

    @Override
    public IListOfInts prepend(int data){
        return new ElementNode(data,this);
    }

    @Override
    public IListOfInts append(int data){
        return append(data);
    }

    @Override
    public IListOfInts insertAtIndex(int data, int index) throws IllegalArgumentException{
        if(index == 0) return prepend(data);
        throw new IllegalArgumentException("Invalid index to insert an element");
    }

    @Override
    public int getDataAtIndex(int index) throws IllegalArgumentException{
        throw new IllegalArgumentException("Wrong index");
    }

    @Override
    public IListOfInts getRest() throws IllegalArgumentException{
        throw new IllegalArgumentException("Null");
    }

    @Override
    public int getCount(){
        return 0;
    }

    @Override
    public  int getSum(){
        return 0;
    }

    @Override
    public String toString() {
        return "";
    }
}
