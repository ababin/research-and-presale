package ru.absoft.langdetect;


import java.util.List;
import java.util.Set;

import org.apache.tika.langdetect.OptimaizeLangDetector;
import org.apache.tika.language.LanguageIdentifier;
import org.apache.tika.language.LanguageProfile;
import org.apache.tika.language.detect.LanguageDetector;
import org.apache.tika.language.detect.LanguageResult;
import org.junit.jupiter.api.Test;



public class AppTest {
    
    private LanguageDetector langDetector = new OptimaizeLangDetector().loadModels();
        
    @Test
    public void test() {
        doDetectAndShowResult("Is it the english text or the russian ?");
        doDetectAndShowResult("А это русский текст, сейчас посмотрим, насколько хорошо работает либа");
        doDetectAndShowResult("А это smeshanny text na angliyskom i russkom i esche s translitom");
        doDetectAndShowResult("А это руский текст, сейчс посмотрм, наскольк хорошо арботает либа, но слва с ошбками");
        doDetectAndShowResult("Барлық адамдар тумасынан азат және қадір-қасиеті мен құқықтары тең болып дүниеге келеді");
    }
    
    @Test
    public void test_showLangs() {
        LanguageIdentifier id = new LanguageIdentifier(new LanguageProfile());
        Set<String> langs = id.getSupportedLanguages();
        System.out.println("Langs count: " + langs.size());
        langs.forEach(s->System.out.println(s));
    }
    
    private void doDetectAndShowResult(String text) {
        LanguageResult res = langDetector.detect(text);
        System.out.println("---------------------------------------------");
        System.out.println("Text: " + text);
        System.out.println("Language: " + res.getLanguage());
        System.out.println("Confidence: " + res.getConfidence());
        System.out.println("Probability: " + res.getRawScore());
        System.out.println("Is the detection reliable? " + res.isReasonablyCertain());
    }
    
}
