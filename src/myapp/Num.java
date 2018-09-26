package myapp;

class Num{
    private int[] num;
    /**
     *
     * @param r 上限值，总值和分母不能大于此值
     */
    
    public Num(int r) {
        num = new int[3];
        num[2] = (int)(Math.random() * r);

        if(num[2] == 0) {
            num[0] = num[1];
            num[1] = 0;
        } else {
            num[1] = (int)(Math.random() * r) * (int)(Math.random() * r) % num[2] * r;

            num[0] = num[1] / num[2];
            num[1] = num[1] % num[2];
            if(num[1] == 0) {
                num[2] = 0;
            }

            if(num[1] != 0 && num[2] != 0)
            {
                int gcdNumber = gcd(num[1], num[2]);
                num[1] /= gcdNumber;
                num[2] /= gcdNumber;
            }
        }
    }

    private Num(int[] num) {
        this.num = num.clone();
    }

    public boolean equals(Num o) {
    	if((num[0] == o.num[0]) && (num[1] == o.num[1]) && (num[2] == o.num[2])) {
    		return true;
    	}
        return false;
    }

    public String getFromatNumber() {
        String str = new String();
        if(num[2] == 0) {
            str += String.valueOf(num[0]);
        } else {
        	if(num[1] == 0) {
        		str += String.valueOf(num[0]);
        	}
        	else if(num[0] != 0) {
                str += String.valueOf(num[0]) + '\''
                        + String.valueOf(num[1]) + '/' + String.valueOf(num[2]);
            } else {
                str += String.valueOf(num[1]) + '/' + String.valueOf(num[2]);
            }
        }

        return str;
    }

    private int gcd(int a, int b) {
        return (b != 0) ? gcd(b, a % b) : a;
    }

    private int[] reduction(Num num) {
        int[] temp = new int[2];

        if(num.num[2] == 0) {
            temp[0] = num.num[0];
            temp[1] = 1;
        } else {
            temp[0] = num.num[1] + num.num[0] * num.num[2];
            temp[1] = num.num[2];
        }

        return temp;
    }

    public Num add(Num other) {
        int[] a = reduction(this);
        int[] b = reduction(other);

        int[] res = new int[3];
        res[1] = a[0] * b[1] + a[1] * b[0];
        res[2] = a[1] * b[1];

        int gcdNumber = gcd(res[1], res[2]);
        res[1] /= gcdNumber;
        res[2] /= gcdNumber;

        res[0] = res[1] / res[2];
        res[1] %= res[2];

        return new Num(res);
    }

    public Num sub(Num other) {
        int[] a = reduction(this);
        int[] b = reduction(other);

        int[] res = new int[3];
        res[1] = a[0] * b[1] - a[1] * b[0];
        res[2] = a[1] * b[1];

        int gcdNumber = gcd(res[1], res[2]);
        res[1] /= gcdNumber;
        res[2] /= gcdNumber;

        res[0] = res[1] / res[2];
        res[1] %= res[2];

        if(res[0] < 0 || res[1] < 0)
            return null;
        return new Num(res);
    }

    public Num multiply(Num other) {
        int[] a = reduction(this);
        int[] b = reduction(other);

        int[] res = new int[3];
        res[1] = a[0] * b[0];
        res[2] = a[1] * b[1];

        int gcdNumber = gcd(res[1], res[2]);
        res[1] /= gcdNumber;
        res[2] /= gcdNumber;

        res[0] = res[1] / res[2];
        res[1] %= res[2];

        return new Num(res);
    }

    public Num divide(Num other) {
        int[] a = reduction(this);
        int[] b = reduction(other);

        if(b[0] == 0)
            return null;

        int[] res = new int[3];
        res[1] = a[0] * b[1];
        res[2] = a[1] * b[0];

        int gcdNumber = gcd(res[1], res[2]);
        res[1] /= gcdNumber;
        res[2] /= gcdNumber;

        res[0] = res[1] / res[2];
        res[1] %= res[2];

        return new Num(res);
    }

}