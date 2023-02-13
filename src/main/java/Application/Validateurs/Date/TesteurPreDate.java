package Application.Validateurs.Date;

public abstract class TesteurPreDate {
    TesteurPreDate next;
    public boolean hasNext() {
        return this.next != null;
    }

    public void setNext(TesteurPreDate t) {
        next = t;
    }

    public boolean test(PreDate subject) {
        if(hasNext()) {
            return next.test(subject);
        }
        return true;
    }
}
