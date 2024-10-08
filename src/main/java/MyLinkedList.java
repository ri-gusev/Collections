import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T>, MyQueu<T> {

    private Node first;
    private Node last;
    private int size = 0;

    @Override
    public T get(int index) {
        return getNode(index).value;
    }

    @Override
    public boolean add(T car) {
        if (size == 0) {
            first = new Node(null, car, null);
            last = first;
        }else{
            Node secondLast = last;
            last = new Node(secondLast, car, null);
            secondLast.next = last;
        }
        size++;
        return true;
    }

    @Override
    public T peek() {
        return size > 0 ? get(0) : null;
    }

    @Override
    public T poll() {
        if (size > 0) {
            Node node = getNode(0);
            remove(node.value);
            return node.value;
        }else{
            return null;
        }
    }

    @Override
    public boolean add(T car, int index) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if (index == size){
            return add(car);
        }

        Node NodeNext = getNode(index); // Получаем объект, который лежит под этим индексом В ДАННЫЙ МОМЕНТ
        Node NodePrevious = NodeNext.previous; //Получаем предыдущий элемент объекта NodeNext(который лежит под этим индексом сейчас)
        Node NewNode = new Node(NodePrevious, car, NodeNext); //Создаем новый объект Node
        // Previous является элемент, который является предыдущим у текущего элемента по этому индексу на данный момент.
        // Следующим эл-ом является элемент, который является текущим элементом по этому индексу в данный момент(так как мы меняем индексы).
        // Теперь новый элемент становится на место элемента, который стоит СЕЙЧАС по этому индексу, а другой элемент, который стоит СЕЙЧАС по этому индексу ->
        //мы ставим на место следующего элемента (next)

        //В следующих строках мы будем менять ссылки на объекты(так как у нас появился новый объект, который мы хотим добавить между других)
        NodeNext.previous = NewNode;// теперь если через элемент следующий после NewNode ссылаться на предыдущий то мы будем ссылаться на NewNode
        //если у нас будет NodeNext первым элементом, то NodePrevious будет null
        // соответственно вызов у null .next приведет к ошибке(поэтому мы обрабатываем в if else)
        if (NodePrevious != null){ // если NodePrevious не null, то делаем так что следующий элемент после NodePrevious будет NewNode
            NodePrevious.next = NewNode;
        }else { //если же NodePrevious null, то мы добавляем новый элемент на первое место
            first = NewNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(T car) {
        int index = findElement(car);

        if (index != -1){
            return removeAt(index);
        }
        return false;
    }

    @Override
    public boolean contains(T car) {
        return findElement(car) != -1;
    }

    private int findElement(T car){
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(car)){
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public boolean removeAt(int index) {
        Node deleteNode = getNode(index);//Создаем ветку с элементом который будем удалять
        Node nodeNext = deleteNode.next;// создаем ветку с последующим элементом
        Node nodePrevious = deleteNode.previous;// создаем ветку с предыдущим элементом

        if(nodeNext != null) {// если nodeNext не null, то меняем ссылку к обращению к предыдущему элементу
            nodeNext.previous = nodePrevious;
        }else {// если null, то мы не можем обратиться через .next к null и мы просто на последнее место ставим последующий элемент nodePrevious
            last = nodePrevious;
        }

        if(nodePrevious != null){// если nodePrevious не null, то меняем ссылку к обращению к последующему элементу
            nodePrevious.next = nodeNext;
        }else{// если null, то мы не можем обратиться через .previous к null и мы просто на первое место ставим последующий элемент nodeNext
            first = nodeNext;
        }

        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){

            private Node node = first;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                T car = node.value;
                node = node.next;
                return car;
            }
        };
    }

    private Node getNode(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node res = first;
        for (int i = 0; i < index; i++) {
            res = res.next;
        }
        return res;
    }

    private class Node{
        private Node previous;
        private T value;
        private Node next;

        public Node(Node previous, T value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}
