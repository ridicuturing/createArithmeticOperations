package myapp;

class CTree { //Calculation tree
    private static String[] mapping = new String[]{"＋", "－", "×", "÷"};
    private CTree parent;
    private CTree lchild;
    private CTree rchild;
    //private String operation;//数据域
    private int operationType;
    private Num num;

    public Num getAnswer() {
        if(isNumber())
            return num;
        if(lchild == null || lchild.getAnswer() == null)
            return null;
        switch (operationType){
            case 0:
                return lchild.getAnswer().add(rchild.getAnswer());
            case 1:
                return lchild.getAnswer().sub(rchild.getAnswer());
            case 2:
                return lchild.getAnswer().multiply(rchild.getAnswer());
            case 3:
                return lchild.getAnswer().divide(rchild.getAnswer());
        }
        return null;
    }


    public String getFormula() {
        if(isNumber())
            return num.getFromatNumber();
        if(isRoot() || (operationType/2 >= parent.operationType/2))
            return lchild.getFormula() + mapping[operationType] + rchild.getFormula();
        return "(" + lchild.getFormula() + mapping[operationType] + rchild.getFormula() + ")";
    }

    public CTree(CTree parent, int depth, int r) {
        //System.out.println(depth);
        this.parent = parent;
        if(depth == 0) {
            lchild = null;
            rchild = null;
            num = new Num(r);
            //System.out.println(num.getFromatNumber());
        } else {
            operationType = (int)(Math.random() * 4);
            lchild = new CTree(this, depth - 1, r);
            rchild = new CTree(this, 0, r);
        }
    }

    public boolean equals(CTree s) { //比较树是否相同 ,不区分左右子树位置不同
        if(s == null) {
            return false;
        }
        if(isNumber() != s.isNumber()) {
            return false;
        }
        if(isNumber() == true) {
            //System.out.println(this.getFormula() + " cmp " + s.getFormula());
            return num.equals(s.num);
        }
        if(operationType != s.operationType) {
            return false;
        }

        return (lchild.equals(s.lchild) && rchild.equals(s.rchild))
                 || (lchild.equals(s.rchild) && rchild.equals(s.lchild));
    }

    public boolean isNumber() {
        return lchild == null;
    }

    public boolean isRoot() {
        return parent == null;
    }
}