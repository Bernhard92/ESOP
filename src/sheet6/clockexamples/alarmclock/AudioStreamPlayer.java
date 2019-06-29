package sheet6.clockexamples.alarmclock;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * A helper class that provides one single method for playing an audio stream.
 * Its play-method expects the path to an audio file.
 *
 * @author ESOP Team 2019
 *
 */
public class AudioStreamPlayer {
    /**
     * Plays the specified audio file.
     *
     * @param path the path to the audio file
     */
    public void play(String path){
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File(
                    path));
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        }catch(UnsupportedAudioFileException uae) {
            System.out.println(uae);
        }catch(IOException ioe) {
            System.out.println(ioe);
        }catch(LineUnavailableException lua) {
            System.out.println(lua);
        }
    }

}
