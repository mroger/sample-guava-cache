package br.org.roger.spring;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

//import org.apache.log4j.Logger;

public class I18nHelper {

	/**
	 * recebe uma string de 5 caracteres com laguange_country no padrao ISO-639
	 * exemplo : en_US , pt_BR etc.. e retorna um objeto Locale.
	 */
	public static Locale parseLocale(String languageCountry ){
		
		if(languageCountry.equals("en_UK")){
			return Locale.UK;
		}
		
		String[] terms = languageCountry.split("_");
		
		Locale locale = null;
			
		if( terms.length == 2 ){
			
			locale = new Locale(terms[0],terms[1]);
			
		}else{
			throw new RuntimeException("Locale nao eh um formato aceito");
		}
		
		return locale;
		
	}
	
	/**
	 * Converter data para o timeZone solicitado
	 */
	public static String converterTimeZone(Date dataOriginal, String localeId , String timezoneId, String formatParam){
		
		String dataFormatada = "";
		
		try{



			SimpleDateFormat dateFormat = new SimpleDateFormat(formatParam, parseLocale(localeId));
			dateFormat.setTimeZone( TimeZone.getTimeZone( timezoneId ));
			dataFormatada = dateFormat.format(dataOriginal);
			
			//log.debug("dataFormatada:" + dataFormatada);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return dataFormatada;
	
	}
	
	/**
	 * Converter data para o timeZone solicitado
	 */
	public static String converterTimeZoneDataHoraFormatoLocal(Date dataOriginal, String localeId, String timezoneId , int formatParam){
		
		String dataFormatada = "";
		
		try{
			
			DateFormat dateFormat = DateFormat.getTimeInstance(formatParam, parseLocale(localeId));
			dateFormat.setTimeZone( TimeZone.getTimeZone( localeId ));
			dataFormatada = dateFormat.format(dataOriginal);
			boolean isInDayLightTime = dateFormat.getTimeZone().inDaylightTime(dataOriginal);
			dataFormatada += " (" +dateFormat.getTimeZone().getDisplayName(isInDayLightTime, TimeZone.SHORT, parseLocale(localeId)) + ")";
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return dataFormatada;
	
	}

	/**
	 * Converter data para o timeZone solicitado
	 */
	public static String convertTimeZoneDate(Date dataOriginal, String localeId, String timezoneId , int formatParam){

		String dataFormatada = "";

		try{

			DateFormat dateFormat = DateFormat.getTimeInstance(formatParam, parseLocale(localeId));
			dateFormat.setTimeZone( TimeZone.getTimeZone( localeId ));
			dataFormatada = dateFormat.format(dataOriginal);
			boolean isInDayLightTime = dateFormat.getTimeZone().inDaylightTime(dataOriginal);
			dataFormatada += " (" +dateFormat.getTimeZone().getDisplayName(isInDayLightTime, TimeZone.SHORT, parseLocale(localeId)) + ")";

		}catch (Exception e) {
			e.printStackTrace();
		}

		return dataFormatada;

	}

    public static String formatDateToTimezone(Date dataOriginal, String timezoneId) {

		/*
			A classe simple date format nao atende os requisitos de impressao da ISO8601
			conforme o parão de impressao do JAXB para objetos do tipo Date.

			SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
			isoFormat.setAuctionTimeZone(TimeZone.getAuctionTimeZone(timezoneId));
		*/

		Calendar cal = Calendar.getInstance();
		cal.setTime(dataOriginal);

		if(timezoneId != null) {
			cal.setTimeZone(TimeZone.getTimeZone(timezoneId));
		}

		String dateConvertedInIsoFormat = javax.xml.bind.DatatypeConverter.printDateTime(cal);

		return dateConvertedInIsoFormat;

	}


	/**
	 * Converter data para o timeZone solicitado
	 */
	public static String converterTimeZoneDiaMesAnoFormatoLocal(Date dataOriginal, String localeId, String timezoneId , int formatParam){
		
		String dataFormatada = "";
		
		try{
			
			DateFormat dateFormat = DateFormat.getDateInstance(formatParam, parseLocale(localeId));
			dateFormat.setTimeZone( TimeZone.getTimeZone(timezoneId));
			dataFormatada = dateFormat.format(dataOriginal);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return dataFormatada;
	
	}
	
	
	/**
	 * Converter data para o timeZone solicitado
	 */
	public static String converterTimeZone(final Date dataOriginal, final String timeZoneId, final String formatParam){
		String dataFormatada = "";

		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat(formatParam);
			dateFormat.setTimeZone(TimeZone.getTimeZone(timeZoneId));
			dataFormatada = dateFormat.format(dataOriginal);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dataFormatada;
	}


	
	/**
	 * recebe o id unico do timezone exemplo : America/Sao Paulo 
	 */
	public static TimeZone parseTimeZone(String timeZoneId ){
		TimeZone timeZone = TimeZone.getTimeZone(timeZoneId);
		return timeZone;
		
	}
	
	/**
	 * Pegar a instancia de Calendar internacionalizado.
	 * 
	 * @author Chen
	 * @date 2008/8/25
	 *
	 * @param timeZoneId
	 * @param localeId
	 * @return
	 */
	public static Calendar getCalendarInstance(String timeZoneId, String localeId){
		return Calendar.getInstance(TimeZone.getTimeZone(timeZoneId), parseLocale(localeId));
	}
	
	/**
	 * O método conta somente dias utéis, retornando  
	 * a data contar a partir da data.
	 * 
	 * No context i18n, o TimeZone e Locale devem ser informado.
	 * 
	 * @author Chen
	 * @date 2008/8/25
	 *
	 * @param data
	 * @param timeZoneId
	 * @param localeId
	 * @param dias
	 * @return resultado
	 */
	public static Date addDiasUteis(Date data, String timeZoneId, String localeId, int dias){
		Calendar c = getCalendarInstance(timeZoneId, localeId);
		c.setTime(data);
		addDiasUteis(c, dias);
		return c.getTime();
	}
	
	/**
	 * O método conta somente dias utéis, retornando  
	 * a data contar a partir da data fornecida.<br><br>
	 * 
	 * No context i18n, o Calendar tem que esteja com TimeZone e Locale Setados corretamente.
	 * 
	 * @author Chen
	 * @date 2008/8/25
	 *
	 * @param c Calendar com data setada para ser calculada
	 * @param dias
	 * @return
	 */
	public static void addDiasUteis(Calendar c, int dias){
		int diasCount = 0;
		if(dias >= 0){
			while(diasCount < dias){
				c.add(Calendar.DATE, 1);

				int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
				if( dayOfWeek != Calendar.SUNDAY && dayOfWeek != Calendar.SATURDAY){

					diasCount++;
				}
			}
		}else{
			while(diasCount > dias){
				c.add(Calendar.DATE, -1);

				int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
				if( dayOfWeek != Calendar.SUNDAY && dayOfWeek != Calendar.SATURDAY){

					diasCount--;
				}
			}
		}
	}
	
	/**
	 * Setar o date para 23:59:59
	 * 
	 * @author Chen
	 * @date 2008/8/26
	 *
	 * @param c
	 */
	public static void finalDoDia(Calendar c){
		// setar o end para 23:59:59
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
	}
	/**
	 * Setar o date para 00:00:00
	 * 
	 * @author Chen
	 * @date 2008/8/26
	 *
	 * @param c
	 */
	public static void inicioDoDia(Calendar c){
		// setar o date para 00:00:00
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
	}

	
	/**
	 * Retorna uma data convertida para o timezone definido no helper 
	 * mostrando as infomacoes de Dia Mes Ano e Hora Minuto e Segundo
	 * formatadas de acordo com o locale.
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDateComplete(Date date, String timezoneId, Locale locale){
		
		DateFormat sdf = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, locale );
		TimeZone tz = I18nHelper.parseTimeZone(timezoneId);
		sdf.setTimeZone(tz);
		return sdf.format(date);
		
	}
	
	public static String formatDateWithoutSeconds(Date date, String timezoneId, Locale locale){
		
		DateFormat sdf = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.SHORT, locale );
		TimeZone tz = I18nHelper.parseTimeZone(timezoneId);
		sdf.setTimeZone(tz);
		return sdf.format(date);
		
	}
	
	public static String formatDateText(Date date, String timezoneId, Locale locale){
		
		DateFormat sdf = DateFormat.getDateInstance(DateFormat.LONG, locale );
		TimeZone tz = I18nHelper.parseTimeZone(timezoneId);
		sdf.setTimeZone(tz);
		return sdf.format(date);
		
	}

	/**
	 * Retorna uma data convertida para o timezone definido no helper 
	 * mostrando as infomacoes de Dia Mes Ano formatadas de acordo com o locale.
	 * @param date
	 * @return
	 */
	public static String parseHoraMinutoSegundo(Date date, Locale locale, String timezoneId){
		
		DateFormat sdf = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale );
		sdf.setTimeZone( I18nHelper.parseTimeZone(timezoneId));
		return sdf.format(date);
		
	}
	
	/**
	 * Retorna uma data convertida para o timezone definido no helper 
	 * mostrando as infomacoes de Dia Mes Ano formatadas de acordo com o locale.
	 * @param date
	 * @return
	 */
	public static String formatTime(Date date, Locale locale, String timezoneId){
		
		DateFormat sdf = DateFormat.getTimeInstance(DateFormat.SHORT, locale );
		sdf.setTimeZone( I18nHelper.parseTimeZone(timezoneId));
		return sdf.format(date);
		
	}
	
	/**
	 * Retorna uma data convertida para o timezone definido no helper 
	 * mostrando as infomacoes de Dia Mes Ano formatadas de acordo com o locale.
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date, Locale locale, String timezoneId){
		
		DateFormat sdf = DateFormat.getDateInstance(DateFormat.DEFAULT, locale );
		sdf.setTimeZone( I18nHelper.parseTimeZone(timezoneId));
		
		return sdf.format(date);
		
	}
	
	public static String formatDateCompleteWithGMT(Date date, String timezoneId, Locale locale){
		
		StringBuffer sb = new StringBuffer();
		sb.append(formatDateComplete(date, timezoneId, locale));
		sb.append(" ");
		// concatenar Info GMT
		sb.append(getGmtOffset(parseTimeZone(timezoneId)));
		return sb.toString();
		
	}
	
	public static String formatDateCompleteWithIdGMT(Date date, String timezoneId, Locale locale){
		
		StringBuffer sb = new StringBuffer();
		TimeZone tz = parseTimeZone(timezoneId);
		sb.append(formatDateComplete(date, timezoneId, locale));
		sb.append(" ");
		sb.append(tz.getID());
		sb.append("(");
		// concatenar Info GMT
		sb.append(getGmtOffset(tz));
		sb.append(")");
		return sb.toString();
		
	}
	
	public static String formatDateCompleteWithoutSecondWithGMT(Date date, String timezoneId, Locale locale){
		
		StringBuffer sb = new StringBuffer();
		sb.append(formatDateWithoutSeconds(date, timezoneId, locale));
		sb.append(" ");
		// concatenar Info GMT
		sb.append(getGmtOffset(parseTimeZone(timezoneId)));
		return sb.toString();
		
	}

	
	public static String formatTimeWithGMT(Date date, Locale locale, String timezoneId){
		StringBuffer sb = new StringBuffer();
		sb.append(parseHoraMinutoSegundo(date, locale, timezoneId));
		sb.append(" ");
		// concatenar Info GMT
		sb.append(getGmtOffset(parseTimeZone(timezoneId)));
		return sb.toString();
		
	}

	
	public static String getGmtOffset(TimeZone tz){
		StringBuffer sb = new StringBuffer();
		sb.append("GMT ");
		int d = 0;
		if(tz.useDaylightTime()){
			if(tz.inDaylightTime(new Date())){
				d = (tz.getRawOffset()+tz.getDSTSavings())/60000;
			}else{
				d = tz.getRawOffset()/60000;
			}
		}else{
			d = tz.getRawOffset()/60000;
		}
		sb.append(formatarHoraMin(d));
		return sb.toString();
	}
	
	public static String getGmtOffset(String timezoneId){
		return getGmtOffset(parseTimeZone(timezoneId));
	}
	
	private static String formatarHoraMin(int minutos){
		StringBuffer sb = new StringBuffer();
		if(minutos < 0){
			minutos = - minutos;
			sb.append("-");
		}
		int hora = minutos/60;
		if(hora < 10){
			sb.append("0");
			sb.append(hora);
		}else{
			sb.append(hora);
		}
		int resto = minutos%60;
		if(resto == 0){
			sb.append(":00");
		}else{
			if(resto < 10){
				sb.append(":0");
				sb.append(resto);
			}else{
				sb.append(":");
				sb.append(resto);
			}
		}
		return sb.toString();
	}

	
	private static String formatCurrencyWithoutSymbol(Double valor, Locale locale, Currency currency){
		NumberFormat nf = NumberFormat.getNumberInstance(locale);
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
		
		// COLOMBIA - Tratamento especifico para o Colombia; colombia nao tem centavo no currency.
		if( getCurrencyFromLocale(locale, currency).getCurrencyCode().equals("COP") ) {
			nf.setMinimumFractionDigits(0);
			nf.setMaximumFractionDigits(0);
		}
		
		return String.format("%s", nf.format(valor));
	
	}

	
	
	/**
     * O NumberFormat possui um utilizacao muito simples e existem dois metodos para a formatacao.
     * parseMoeda( double,  locale );
     * parseMoeda( double,  currency );
     * 
     * o primeiro gera um formatcao diferente do outro.. 
     * por isso nao existe sentido em um desses metodos reutilizar o outro.
     * sao implementacoes diferentes de NumberFormat. ou seja nao retorna 
     * o mesmo valor . 
     * 
     * para locale es_AR  e o metodo  parseMoeda( double,  locale );  ele retorna $300,00
     * ja para locale es_AR  e o metodo  parseMoeda( double,  currency );  ele retorna ARS 300,00
     * 
     * para aprensetação na home normalmente deve ser utilizado o primeiro metodo.
	 * 
	 * Retorna a moeda formatada e com o simbolo pelo locale. <br>
	 * es_AR = $300,00 <br>
	 * pt_BR = R$ 300,00 <br>
	 * etc...<br>
	 * 
	 * porem para casos em que a simbolo seja igual exemplo  es_AR e es_MX utilizam
	 * $300,00  entao foi criado um metodo parseMoeda( double,  currency, locale )
	 * que vai concatenar o codigo da moeda junto ao valor formatado.
	 * 
	 * 
	 * @param number
	 * @return
	 */
	public static String parseMoeda(Double valor, Locale locale){
		return I18nHelper.formatCurrency(valor, locale, null);
	}
	
	public static String parseMoedaSemCodigo(Double valor, Locale locale){
		return I18nHelper.formatCurrencyWithoutCurrencyCode(valor, locale, null);
	}
	
	public static String parseMoedaSimplificada(Double valor, Locale locale){
		NumberFormat nf = NumberFormat.getNumberInstance(locale);
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
		
		return nf.format(valor);
	}
	
	
	public static String parseMoeda(Double valor, Locale locale, Currency currency){
		return I18nHelper.formatCurrency(valor, locale, currency);
	}
	
	
	/**
	 * Tratar locales inexistentes para a lista de Currency.
	 * 
	 * @param locale
	 * @return
	 */
	public static Locale fixOldLocales(Locale locale){
		
		// Tratar locales inexistentes para o Currency.getInstance
		if( locale != null && locale.toString().equals("en_UK") ){
		    return Locale.UK;
		}else{
			return locale;
		}
		
	}

	public static String formatCurrency(Double valor, Locale locale, Currency currency){

		try{

			locale = getLocaleWithCurrencyForLocaleWithoutCurrency(locale);

			NumberFormat nf = NumberFormat.getCurrencyInstance(locale);

			String currencyCode = getCurrencyCode(locale, currency);

			String valueFormated  = nf.format(valor);

			valueFormated = fixWrongFormats(valor, locale, currency, valueFormated);
			valueFormated = fixForNoUTF8(valor, locale, currency, valueFormated);

			return String.format("%s (%s)",
					valueFormated,
					currencyCode);

		}catch (IllegalArgumentException e) {
			NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
			return nf.format(valor);
		}

	}

	/**
	 * Tratar locales inexistentes para a lista de Currency.
	 *
	 * @param locale
	 * @return
	 */
	public static Locale getLocaleWithCurrencyForLocaleWithoutCurrency(Locale locale){

		// Tratar locales inexistentes para o Currency.getInstance
		if( locale != null && locale.toString().equals("en_UK") ){
			return Locale.UK;
		}else{
			return locale;
		}

	}

        public static String formatCurrencyHidden(Double valor, Locale locale, Currency currency){
            
		try{
                    
			locale = fixOldLocales(locale);
			
			NumberFormat nf = null;
			if(currency == null){
				nf = NumberFormat.getCurrencyInstance(locale);
			}else{
				nf = NumberFormat.getCurrencyInstance();
				nf.setCurrency(currency);
			}
			
			String currencyCode = getCurrencyCode(locale, currency);
		
			String valueFormated  = nf.format(valor);
			
			valueFormated = fixWrongFormats(valor, locale, currency, valueFormated);
			valueFormated = fixForNoUTF8(valor, locale, currency, valueFormated);
			
			return hiddenNumbers(valueFormated);
		
                        
                        
		}catch (IllegalArgumentException e) {
			NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
			return hiddenNumbers(nf.format(valor));
		}

	}
        
        private static String hiddenNumbers(String currencyFormated){
            return currencyFormated.replaceAll("\\d+.*", "********");
        }
        
	public static String formatCurrencyWithoutCurrencyCode(Double valor, Locale locale, Currency currency){
		
		try{
			
			locale = fixOldLocales(locale);
			
			NumberFormat nf = null;
			if(currency == null){
				nf = NumberFormat.getCurrencyInstance(locale);
			}else{
				nf = NumberFormat.getCurrencyInstance();
				nf.setCurrency(currency);
			}
			
			String currencyCode = getCurrencyCode(locale, currency);
		
			String valueFormated  = nf.format(valor);
			
			valueFormated = fixWrongFormats(valor, locale, currency, valueFormated);
			valueFormated = fixForNoUTF8(valor, locale, currency, valueFormated);
			
			return valueFormated;
		
		}catch (IllegalArgumentException e) {
			NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
			return nf.format(valor);
		}

	}
	
    public static String getCurrencyCodeFromLocale(Double valor, Locale locale){
		
		try{
			
			locale = fixOldLocales(locale);
			String currencyCode = getCurrencyCode(locale, null);
			return currencyCode;
		
		}catch (IllegalArgumentException e) {
			return "";
		}

	}

	
	/**
	 * Corrigir formatacoes que resultem em characteres nao permitidos
	 * no charsets diferentes de UTF-8.
	 * 
	 * @param valor
	 * @param locale
	 * @param c
	 * @param currencyFormated
	 * @return
	 */
	private static String fixForNoUTF8(Double valor, Locale locale,
                                       Currency c, String currencyFormated) {
		
		String fixed = currencyFormated;
	
		if(!java.nio.charset.Charset.defaultCharset().name().equals("UTF-8")){				
		
			if(getCurrencyFromLocale(locale, c).getCurrencyCode().equals("EUR") ||
			   getCurrencyFromLocale(locale, c).getCurrencyCode().equals("JPY") ||
			   getCurrencyFromLocale(locale, c).getCurrencyCode().equals("RUB") ) {
				fixed = formatCurrencyWithoutSymbol(valor, locale, c);
			}
			
		}
		
		return fixed;
		
	}

	/**
	 * Corrigi formatacoes indesejadas como por exemplo :<br>
	 *   - No chile nao se utiliza o simbolo de acordo com o ISO de padrao
         * internacional, mas sim um convensao local representada apenas por $
	 * 
	 * @param valor
	 * @param locale
	 * @param c
	 * @param currencyFormated
	 * @return
	 */
	private static String fixWrongFormats(Double valor, Locale locale,
                                          Currency c, String currencyFormated) {
		
		String fixed = currencyFormated;
		
		// CHILE - Tratamento especifico para o chile;
		if( getCurrencyFromLocale(locale, c).getCurrencyCode().equals("CLP") ) {
			fixed = currencyFormated.replace("Ch$", "$");
		    // No chile nao se utiliza o simbolo de acordo com o ISO de padrao
		    // internacional, mas sim um convensao local representada apenas por $
		}
		
		// PERU - Tratamento especifico para o Peru;
		if( getCurrencyFromLocale(locale, c).getCurrencyCode().equals("PEN") ) {
			fixed = currencyFormated.replace("S/", "S/. ");
		}
		
		// COLOMBIA - Tratamento especifico para o Colombia;
		if( getCurrencyFromLocale(locale, c).getCurrencyCode().equals("COP") ) {
			fixed = currencyFormated.substring(0, currencyFormated.length()-3);
		}
		
		return fixed;
				
	}

	private static Currency getCurrencyFromLocale(Locale locale, Currency currency) {
		
		// GET CURRENCY CODE - currency para resgatar o currency code.
     	Currency c = null;
		if( currency != null ){
			return currency;
		} else {
	     	return Currency.getInstance(locale);
		}
	}
	
	private static String getCurrencyCode(Locale locale, Currency currency) {
		String currencyCode = "";
		
		Currency c = getCurrencyFromLocale(locale, currency);
		if(c != null){
		   currencyCode =  c.getCurrencyCode();
		}
		
		return currencyCode;
		
	}

	
	
	
	/**
	 * Retorna uma valor formatado na moeda do locale definido no helper
	 * Esse tipo de formatacao passando currency retorna o ID da moeda.
	 * e nao o simbolo.. exemplo para argentina retorna ARS 1.00,00 
	 * ao inves de $1.00,00 .. para retornar a formatacao com o simbolo
	 * utiliza-se o parseMoeda(Double, Locale) 
	 * 
	 * @param number
	 * @return
	 */
	public static String formatCurrency(Double valor, Currency moeda){
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        nf.setCurrency(moeda);
        
        if( moeda.getCurrencyCode().equals("CLP")) {
        	return removeCentsForChile(nf.format(valor), moeda);
        } else {
        	return nf.format(valor);
        }
	}
	
	
	/**
	 * Workaround para retirar os centavos do chile segundo
	 * defino por ricardo salles. Isso tambem para evitar
	 * o numero exagerado de digitos uma vez que a moeda
	 * CLP normalmente gera numeros grandes.
	 * @throws Exception
	 */
	private static String removeCentsForChile(String dataFormatada, Currency moeda){
		
		if( moeda.getCurrencyCode().equals("CLP")){
			String semcentavos = "";
			
			try{
				
				// Retira a virgula e as casa decimais de centavos.
				String[]valor = dataFormatada.split(",");
				semcentavos = valor[0];
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
			return semcentavos;
		}else{
			return dataFormatada;
		}
		
	}
	
	/**
	 * Retorna um valor formatado para o locale definido no helper
	 * O valor retornado é formatado para o mínimo e máximo de casas
	 * decimais passados por parâmetro
	 * @param numero
	 * @param minDigitosDecimais
	 * @param maxDigitosDecimais
	 * @return
	 */
	public static String parseNumero(Double numero, int minDigitosDecimais, int maxDigitosDecimais, Locale locale){
        NumberFormat nf = NumberFormat.getNumberInstance(locale);
        nf.setMinimumFractionDigits(minDigitosDecimais);
        nf.setMaximumFractionDigits(maxDigitosDecimais);
		return nf.format(numero);
	}
	
	/**
	 * Retornar o valor formatado com a formatação padrão
	 * 
	 * @param numero
	 * @param minDigitosDecimais
	 * @param maxDigitosDecimais
	 * @return
	 */
	public static String parseNumeroPadrao(Double numero, Locale locale){
		return parseNumero(numero, 2, 2, locale);
		
	}

	
	/**
	 * Para casos em que a simbolo seja igual exemplo  es_AR e es_MX utilizam
	 * $300,00  entao foi criado um metodo parseMoeda( double,  currency, locale )
	 * que vai concatenar o codigo da moeda junto ao valor formatado.
	 * <br>
	 * exemplo:<br><br>
	 * es_MX = (MXL) $300,00
	 * es_AR = (ARS) $300,00
	 * <br>
	 * <b>IMPORTANTE O LOCALE DEVE SE RO MESMO LOCALE DA MOEDA !!!<b><br>
	 * 
	 * @param convertido
	 * @param moedaRef
	 * @param localeFormatacao
	 * @return String
	 * @deprecated
	 */
	public static String parseMoeda(Double valor, Currency moedaRef,
                                    Locale localeFormatacao) {
		
		if( !Currency.getInstance(localeFormatacao).equals( moedaRef ) ){
			throw new IllegalArgumentException("MoedaRef deve ser correspondente ao LocaleFormatacao");
		}
		
		StringBuffer moeda = new StringBuffer();
		moeda.append( parseMoeda(valor, localeFormatacao) );
		moeda.append( " (" ).append(moedaRef.getCurrencyCode()).append(")");
		
		return moeda.toString();
		
	}
	
	public static String formatCurrencyToLocale(Double valor, String localeId){
		String vlr = I18nHelper.formatCurrencyWithoutCurrencyCode(valor, parseLocale(localeId), null);
        String code = I18nHelper.getCurrencyCodeFromLocale(valor, parseLocale(localeId));
		return String.format("%s (%s)", vlr, code );
	}
	

	
}
