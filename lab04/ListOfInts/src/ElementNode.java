public class ElementNode implements IListOfInts{
    public IListOfInts rest;
    public int data;

    public ElementNode(int data, IListOfInts rest){
        this.data = data;
        this.rest = rest;
    }

    @Override
    public IListOfInts prepend(int data){

    }

    @Override
    public IListOfInts append(int data){

    }

    @Override
    public IListOfInts insertAtIndex(int data, int index){

    }

    @Override
    public int getDataAtIndex(int index){

    }

    @Override
    public IListOfInts getRest(IListOfInts lst){

    }

    @Override
    public int getCount(){

    }

    @Override
    public  int getSum(){

    }



}
