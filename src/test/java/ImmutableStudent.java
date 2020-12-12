public final class ImmutableStudent {

    private final int id;

    ImmutableStudent(int id) {
            this.id = id;
    }


    public ImmutableStudent setId(int id) {
         if(this.id == id) {
             return this;
         }
         return (new ImmutableStudent(id));
    }

    public int getId() {
        return id;
    }


    public static void main(String[] args) {
        ImmutableStudent is1 = new ImmutableStudent(10);
        ImmutableStudent is2 = new ImmutableStudent(10);
        is1.setId(10);


        System.out.println(is1 == is1.setId(10));
        System.out.println(is1 == is1.setId(11));
        System.out.println(is1 == is2.setId(10));
        System.out.println(is1 == is2);
    }

}
