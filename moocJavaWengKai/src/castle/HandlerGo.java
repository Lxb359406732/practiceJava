package castle;

public class HandlerGo extends Handler
{

    public HandlerGo(Game game)
    {
        super(game);
    }

    @Override
    public void doCmd(String word)
    {
        game.goRoom(word);
    }

    public static void main(String[] args)
    {

    }
}
