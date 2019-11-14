package project1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EresCounter
{
  public EresCounter()
  {
    super();
  }

  public static void main( String[] args )
  {
    File localDir;
    File[] files;
    localDir = new File( "C:\\Users\\drickard1967\\Desktop\\eres 18-19" );
    files = localDir.listFiles();
    if ( files != null && files.length != 0 )
    {
      for ( File theFile : files )
      {
        BufferedReader reader;
        String line;
        int count;

        line = null;
        count = 0;

        try
        {
          reader = new BufferedReader( new FileReader( theFile ) );
          while ( ( line = reader.readLine() ) != null )
          {
            if ( line.contains( "connect" ) && line.contains( "audioreserves" ) && !line.contains( "disconnect" ) )
            {
              count += 1;
            }
          }
          if ( count > 0 )
          {
            System.out.println( theFile.getName().substring( 32 ) + "," + count );
          }
        }
        catch ( FileNotFoundException fnfe )
        {
          fnfe.printStackTrace();
        }
        catch ( IOException ioe )
        {
          ioe.printStackTrace();
        }
      }
    }
  }
}
