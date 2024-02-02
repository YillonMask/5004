public class ElementNode implements IListOfInts{
    public IListOfInts rest;
    public int data;

    public ElementNode(int data, IListOfInts rest){
        this.data = data;
        this.rest = rest;
    }

    @Override
    public IListOfInts prepend(int data){
        return new ElementNode(data,this);
    }

    @Override
    public IListOfInts append(int data){
        this.rest = this.rest.append(data);
        return this;
    }

    @Override
    public IListOfInts insertAtIndex(int data, int index){
        if(index == 0) return prepend(data);
        else{
            this.rest = this.rest.insertAtIndex(data, index - 1);
            return this;
        }
    }

    @Override
    public int getDataAtIndex(int index) throws IllegalArgumentException{
        if(index == 0) return this.data;
        else{
            return this.rest.getDataAtIndex(index - 1);
        }
    }

    @Override
    public IListOfInts getRest(){
        return this.rest;
    }

    @Override
    public int getCount(){
        return 1 + rest.getCount();
    }

    @Override
    public  int getSum(){
        return this.data + rest.getSum();
    }

    @Override
    public String toString() {
        return "(" + this.data +")";
    }
}
