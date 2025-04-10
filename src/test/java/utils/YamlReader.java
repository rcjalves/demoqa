package utils;

import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class YamlReader {

    public static Map<String, Object> lerYaml(String caminho) {
        InputStream inputStream = YamlReader.class.getClassLoader().getResourceAsStream(caminho);
        Yaml yaml = new Yaml();
        return yaml.load(inputStream);
    }

    public static Map<String, String> lerYamlUsuario(String caminho) {
        Map<String, Object> data = lerYaml(caminho);
        return (Map<String, String>) data.get("usuario");
    }
}
