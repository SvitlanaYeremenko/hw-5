class Level {
    private int width;
    private int height;

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

class LevelLoader {
    public void load(Level level) throws LevelTooBigException {
        int square = 0;
        square = level.getHeight() * level.getWidth();
        if (square < 100000) {
            System.out.println("Level loaded");
        } else {
            throw new LevelTooBigException();
        }
    }
}

class LevelTooBigException extends Exception {
    LevelTooBigException() {
        super("Слишком большой уровень, нельзя загрузить.");
    }
}

class LevelLoaderTest {
    public static void main(String[] args) {
        //Level loaded
        try {
            new LevelLoader().load(new Level(10, 20));
        } catch (LevelTooBigException ex) {
            System.out.println("Level too big");
        }

        //Level too big
        try {
            new LevelLoader().load(new Level(10000, 2000));
        } catch (LevelTooBigException ex) {
            System.out.println("Level too big");
        }
    }
}
