package myapp;

class Calculation {
    private CTree tree = null;
    private String formula;

    public Calculation(int r) {
        int rand = (int)(Math.random() * 4);
        tree = new CTree(null, rand, r);
        formula = tree.getFormula();
    }

    public Num getAnswer(){
        return tree.getAnswer();
    }

    public String getFormula() {
        return formula;
    }

    public int hashCode() {
        return formula.hashCode();
    }

    public boolean equals(Object obj) {
        Calculation temp = (Calculation)obj;
        return tree.equals( temp.tree );
    }
}

