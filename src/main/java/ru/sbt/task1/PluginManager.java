package ru.sbt.task1;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;

/**
 * Ваша задача написать загрузчик плагинов в вашу систему. Допустим вы пишите свой браузер и хотите,
 * чтобы люди имели имели возможность писать плагины для него.
 * Соответственно, разные разработчики могут назвать свои классы одинаковым именем,
 * ваш загрузчик должен корректно это обрабатывать.
 *
 * @see ru.sbt.task1.Plugin - это базовый интерфейс  для всех плагинов
 * <p>
 * PluginManager ищет скомпилированные классы плагина в папке pluginRootDirectory\pluginName\
 */
public class PluginManager {
    private final String pluginRootDirectory ;
    java.util.Map <String , URLClassLoader > classLoaderMap = new HashMap<>(  );

    public PluginManager( String pluginRootDirectory ) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load( String pluginName, String pluginClassName ) {
        if ( !classLoaderMap.containsKey( pluginName )){
            URL url = new URL(  pluginRootDirectory +"/"+ pluginName );
            classLoaderMap.put( pluginName,
                    new URLClassLoader( new URL[] {url} )
                    //
            );
        }
    }
}
