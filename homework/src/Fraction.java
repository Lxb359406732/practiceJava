class Fraction {

            private int a;
            private int b;

            Fraction(int a, int b) {
                this.a = a;
                this.b = b;
                simplify();
            }

            Fraction simplify(Fraction c) {
                int n = Math.min(c.a, c.b);
                int max = 1;
                for (int i = 2; i <= n; i++) {
                    if (c.a % i == 0 & c.b % i == 0) {
                        max = i;
                    }
                }
                if (max != 1) {
                    c.a /= max;
                    c.b /= max;
                }
                return c;
            }

    void simplify() {
        int n = Math.min(a, b);
        int max = 1;
        for (int i = 2; i <= n; i++) {
            if (a % i == 0 & b % i == 0) {
                max = i;
            }
        }
        if (max != 1) {
            a /= max;
            b /= max;
        }

    }

            double toDouble() {
                double c = a * 1.0 / b;
                return c;
            }

            Fraction plus(Fraction r) {
                Fraction c = new Fraction(a, b);
                c.a = c.a * r.b + c.b * r.a;
                c.b = r.b * c.b;
                return simplify(c);
            }

            Fraction multiply(Fraction r) {
                Fraction c = new Fraction(a, b);
                c.a = c.a * r.a;
                c.b = r.b * c.b;
                return simplify(c);
            }

            void print() {
                if (a == 1 && b == 1) {
                    System.out.println(1);
                } else {
                    System.out.println(a + "/" + b);
                }

            }


    }

