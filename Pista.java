import greenfoot.*; 

public class Pista extends World {
    private int score;
    private int level;

    private int velocidad_carro;
    private int num_adelantamientos;
    private int num_adelantamientos_nivel;
    private Carro1 alonso;
    private int num_rivales;

    public Pista() {
        super(450, 1000, 1);
        
        num_adelantamientos = 0;
        num_adelantamientos_nivel = 4;
        velocidad_carro = 2;

        score = 0;
        level = 1;
        alonso = new Carro1(velocidad_carro);

        addObject(alonso, 300, 600);
        showScore();
        showLevel();
    }
    
    public void addToScore(int points) {
        score += points;
        showScore();
    }
    
    public void increaseLevel() {
        level++;
        showLevel();
    }
    
    private void showScore() {
        showText("Score: " + score, 205, 60);
    }
    
    private void showLevel() {
        showText("Level: " + level, 205, 90);
    }
    
    public void act() {
        aumentarDificultad();
        aniadirRivales();
    }
    
    public int getRandomNumber(int start, int end) {
        int normal = Greenfoot.getRandomNumber(end - start + 1);
        return normal + start;
    }
    
    public void aumentarPuntuacion(int valor) {
        score += valor;
        showScore();
    }
    
    public void aumentarAdelantamientos() {
        num_adelantamientos++;
    }
    
    public void disminuirNumRivales() {
        num_rivales--;
    }
    
    private void aumentarDificultad() {
        if (num_adelantamientos == num_adelantamientos_nivel) {
            num_adelantamientos = 0;
            increaseLevel();
            alonso.aumentaVelocidad();
        }
    }
    
    private void aniadirRivales() {
        if (num_rivales == 0) {
            
            int carril = getRandomNumber(0, 2);
            
            if (carril == 0) {
                addObject(new Carro2(velocidad_carro), 295, 95);
            } else if (carril == 1) {
                addObject(new Carro2(velocidad_carro), 225, 95);
            } else {
                addObject(new Carro2(velocidad_carro), 205, 95);
            }
            
            carril++;
            carril %= 3;
            
            if (carril == 0) {
                addObject(new Carro2(velocidad_carro), 295, 95);
            } else if (carril == 1) {
                addObject(new Carro2(velocidad_carro), 225, 95);
            } else { 
                addObject(new Carro2(velocidad_carro), 205, 95);
            }
            
            num_rivales = 2;
        }
    }
}
