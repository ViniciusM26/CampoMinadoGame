package campoMinado.ModosJogo;

public class CorpoRetorno{
        private int x,y, modo;

        public CorpoRetorno(int x, int y, int modo){
            setX(x);
            setY(y);
            setModo(modo);
        }
        
        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getModo() {
            return modo;
        }

        public void setModo(int modo) {
            this.modo = modo;
        }
    }
