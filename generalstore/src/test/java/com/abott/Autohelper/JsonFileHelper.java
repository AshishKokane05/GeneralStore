package com.abott.Autohelper;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;

import org.apache.commons.lang3.reflect.FieldUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonStreamParser;

public class JsonFileHelper {

	/**
	 * @author ashish.kokane
	 * @param filePath
	 * @return
	 */
	public JsonArray convertJSONFileToJsonArray(String filePath) {
		JsonArray jsonArray = null;

		try {
			JsonStreamParser jsonParser = new JsonStreamParser(new FileReader(filePath));
			jsonArray = jsonParser.next().getAsJsonArray();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return jsonArray;
	}

	/**
	 * @author ashish.kokane
	 * @param desiredUsrDefinedObject
	 * @param parameter
	 * @param merchantAutoID
	 * @param JsonFile
	 * @return
	 */
	public Object convertJsonFileToUserDefinedObject(Object  desiredUsrDefinedObject, String parameter ,String merchantAutoID , String JsonFile) {
		
		Object objConverted = convertJsonArrayToObject(desiredUsrDefinedObject.getClass(),parameter, merchantAutoID,
				convertJSONFileToJsonArray(JsonFile));
		return objConverted;
	}

	
	/**
	 * @author ashish.kokane
	 * @param objDesired
	 * @param objField
	 * @param objFieldVal
	 * @param convertJSONFileToJsonArray
	 * @return
	 */
	private Object convertJsonArrayToObject(Class<?> objDesired,String objField, String objFieldVal,
			JsonArray convertJSONFileToJsonArray) {
		Object objRet = null;
		for (Object jsonObject : convertJSONFileToJsonArray) {
			com.google.gson.JsonObject appDet;
			appDet = (com.google.gson.JsonObject) jsonObject;
			System.out.println(" Merchant id value" + appDet.get(objField).toString().replaceAll("^\"|\"$", ""));
			if (appDet.get(objField).toString().replaceAll("^\"|\"$", "").equals(objFieldVal)) {
				objRet = new com.google.gson.Gson().fromJson(appDet, objDesired);
				break;
			}
		}
		return objRet;
	}
	
	/**
	 * @author ashish.kokane
	 * @param objToBeConverted
	 * @param desiredUsrDefndObj
	 * @return
	 */
	public Object convertObjectToUserDefinedClassObject(Object objToBeConverted, Object desiredUsrDefndObj) {
		// System.out.println("These are filed values" +
		// objToBeConverted.getClass().getDeclaredFields());
		Field[] fieldValues = objToBeConverted.getClass().getDeclaredFields();
		try {
			for (int fieldCnt = 0; fieldCnt < objToBeConverted.getClass().getDeclaredFields().length; fieldCnt++) {
				Field fieldVal = desiredUsrDefndObj.getClass().getDeclaredField(fieldValues[fieldCnt].getName());
				fieldVal.setAccessible(true);

				if (FieldUtils.readField(objToBeConverted, fieldVal.getName(), true) != null) {
					fieldVal.set(desiredUsrDefndObj, FieldUtils.readField(objToBeConverted, fieldVal.getName(), true));
					// System.out.println(FieldUtils.readField(objToBeConverted,
					// fieldVal.getName()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return desiredUsrDefndObj;
	}

}
