package com.wemote.sdk.wechat.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jayon.xu@gmail.com
 */
public class XStreamJsonExample {

    private String json = "{Music:{albums:[{name:name1,year:1980}]}}";

    public static void main(String[] args) {
        XStreamJsonExample example = new XStreamJsonExample();
        example.serializeJsonUsingxStream();
    }

    private void serializeJsonUsingxStream() {

        XStream xStream = new XStream(new JettisonMappedXmlDriver());
        xStream.processAnnotations(Music7.class);
        Music7 music7 = (Music7) xStream.fromXML(json);
        System.out.println(music7);
        Music7 music = new Music7();
        Album7 album1 = new Album7();
        album1.name = "name1";
        album1.year = 1980;
        music.albums.add(album1);
        Album7 album2 = new Album7();
        album2.name = "name2";
        album2.year = 1981;
        music.albums.add(album2);
        System.out.println(xStream.toXML(music));
    }
}

@XStreamAlias("Music")
class Music7 {
    @XStreamImplicit
    List<Album7> albums = new ArrayList<Album7>();

    @Override
    public String toString() {
        return "Music7 [albums=" + albums + "]";
    }

}

@XStreamAlias("Album")
class Album7 {
    String name;
    int year;

    @Override
    public String toString() {
        return "Album7 [name=" + name + ", year=" + year + "]";
    }

}
