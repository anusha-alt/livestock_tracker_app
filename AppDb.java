package com.example.at_lab_project;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Animal.class}, version = 1)
public abstract class AppDb extends RoomDatabase {
    public abstract AnimalDao animalDao();

    private static volatile AppDb INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static AppDb getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDb.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDb.class, "animal_database")
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    databaseWriteExecutor.execute(() -> {
                                        AnimalDao dao = INSTANCE.animalDao();
                                        dao.deleteAll();
                                        dao.insert(new Animal("Rocky1000", "Dog", 1)); // Suggested: Vaccination
                                        dao.insert(new Animal("Bella1001", "Sheep", 12)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Buddy1002", "Cat", 14)); // Suggested: Vaccination
                                        dao.insert(new Animal("Daisy1003", "Cat", 11)); // Suggested: Regular health check
                                        dao.insert(new Animal("Rocky1004", "Cat", 15)); // Suggested: Deworming
                                        dao.insert(new Animal("Max1005", "Cow", 13)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Charlie1006", "Cat", 11)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Daisy1007", "Goat", 15)); // Suggested: Health Check
                                        dao.insert(new Animal("Max1008", "Goat", 7)); // Suggested: Neutering
                                        dao.insert(new Animal("Luna1009", "Dog", 9)); // Suggested: Deworming
                                        dao.insert(new Animal("Daisy1010", "Cow", 1)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Max1011", "Cow", 2)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Lucy1012", "Cat", 14)); // Suggested: Vaccination
                                        dao.insert(new Animal("Buddy1013", "Cat", 1)); // Suggested: Dental care
                                        dao.insert(new Animal("Buddy1014", "Cat", 10)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Charlie1015", "Dog", 1)); // Suggested: Neutering
                                        dao.insert(new Animal("Luna1016", "Cat", 4)); // Suggested: Deworming
                                        dao.insert(new Animal("Buddy1017", "Dog", 10)); // Suggested: Neutering
                                        dao.insert(new Animal("Jack1018", "Sheep", 11)); // Suggested: Dental care
                                        dao.insert(new Animal("Lucy1019", "Cow", 14)); // Suggested: Dental care
                                        dao.insert(new Animal("Lucy1020", "Cat", 3)); // Suggested: Health Check
                                        dao.insert(new Animal("Max1021", "Sheep", 9)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Bella1022", "Sheep", 11)); // Suggested: Dental care
                                        dao.insert(new Animal("Max1023", "Cat", 8)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Bella1024", "Dog", 7)); // Suggested: Regular health check
                                        dao.insert(new Animal("Lucy1025", "Cow", 14)); // Suggested: Neutering
                                        dao.insert(new Animal("Jack1026", "Cow", 8)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Jack1027", "Cat", 5)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Jack1028", "Cow", 6)); // Suggested: Neutering
                                        dao.insert(new Animal("Rocky1029", "Cat", 10)); // Suggested: Dental care
                                        dao.insert(new Animal("Lucy1030", "Goat", 11)); // Suggested: Neutering
                                        dao.insert(new Animal("Molly1031", "Goat", 14)); // Suggested: Neutering
                                        dao.insert(new Animal("Rocky1032", "Goat", 4)); // Suggested: Neutering
                                        dao.insert(new Animal("Molly1033", "Cat", 7)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Max1034", "Dog", 4)); // Suggested: Regular health check
                                        dao.insert(new Animal("Luna1035", "Cow", 15)); // Suggested: Neutering
                                        dao.insert(new Animal("Buddy1036", "Cow", 2)); // Suggested: Deworming
                                        dao.insert(new Animal("Lucy1037", "Sheep", 15)); // Suggested: Regular health check
                                        dao.insert(new Animal("Luna1038", "Dog", 1)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Daisy1039", "Cow", 10)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Bella1040", "Dog", 10)); // Suggested: Regular health check
                                        dao.insert(new Animal("Jack1041", "Goat", 11)); // Suggested: Vaccination
                                        dao.insert(new Animal("Max1042", "Dog", 4)); // Suggested: Deworming
                                        dao.insert(new Animal("Daisy1043", "Cat", 4)); // Suggested: Health Check
                                        dao.insert(new Animal("Charlie1044", "Sheep", 11)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Daisy1045", "Sheep", 7)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Molly1046", "Sheep", 7)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Daisy1047", "Goat", 15)); // Suggested: Dental care
                                        dao.insert(new Animal("Jack1048", "Goat", 7)); // Suggested: Neutering
                                        dao.insert(new Animal("Daisy1049", "Sheep", 13)); // Suggested: Dental care
                                        dao.insert(new Animal("Max1050", "Sheep", 11)); // Suggested: Vaccination
                                        dao.insert(new Animal("Rocky1051", "Goat", 5)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Molly1052", "Cat", 12)); // Suggested: Deworming
                                        dao.insert(new Animal("Luna1053", "Dog", 15)); // Suggested: Neutering
                                        dao.insert(new Animal("Max1054", "Sheep", 14)); // Suggested: Health Check
                                        dao.insert(new Animal("Rocky1055", "Cat", 13)); // Suggested: Health Check
                                        dao.insert(new Animal("Bella1056", "Cat", 14)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Max1057", "Goat", 5)); // Suggested: Health Check
                                        dao.insert(new Animal("Charlie1058", "Sheep", 13)); // Suggested: Regular health check
                                        dao.insert(new Animal("Luna1059", "Goat", 2)); // Suggested: Vaccination
                                        dao.insert(new Animal("Bella1060", "Sheep", 10)); // Suggested: Neutering
                                        dao.insert(new Animal("Bella1061", "Cat", 8)); // Suggested: Dental care
                                        dao.insert(new Animal("Jack1062", "Goat", 4)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Charlie1063", "Sheep", 5)); // Suggested: Vaccination
                                        dao.insert(new Animal("Daisy1064", "Dog", 7)); // Suggested: Health Check
                                        dao.insert(new Animal("Rocky1065", "Goat", 12)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Buddy1066", "Sheep", 10)); // Suggested: Dental care
                                        dao.insert(new Animal("Luna1067", "Cat", 12)); // Suggested: Vaccination
                                        dao.insert(new Animal("Rocky1068", "Goat", 15)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Luna1069", "Cat", 9)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Max1070", "Goat", 12)); // Suggested: Dental care
                                        dao.insert(new Animal("Daisy1071", "Goat", 9)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Lucy1072", "Goat", 5)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Max1073", "Cow", 1)); // Suggested: Deworming
                                        dao.insert(new Animal("Lucy1074", "Dog", 6)); // Suggested: Vaccination
                                        dao.insert(new Animal("Molly1075", "Goat", 10)); // Suggested: Deworming
                                        dao.insert(new Animal("Molly1076", "Goat", 10)); // Suggested: Deworming
                                        dao.insert(new Animal("Max1077", "Cat", 8)); // Suggested: Regular health check
                                        dao.insert(new Animal("Bella1078", "Cat", 9)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Jack1079", "Dog", 3)); // Suggested: Regular health check
                                        dao.insert(new Animal("Rocky1080", "Cow", 14)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Bella1081", "Cow", 9)); // Suggested: Deworming
                                        dao.insert(new Animal("Rocky1082", "Cow", 7)); // Suggested: Regular health check
                                        dao.insert(new Animal("Luna1083", "Goat", 11)); // Suggested: Health Check
                                        dao.insert(new Animal("Buddy1084", "Cow", 5)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Jack1085", "Cat", 11)); // Suggested: Dental care
                                        dao.insert(new Animal("Max1086", "Sheep", 14)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Daisy1087", "Goat", 8)); // Suggested: Neutering
                                        dao.insert(new Animal("Bella1088", "Dog", 4)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Daisy1089", "Cow", 1)); // Suggested: Health Check
                                        dao.insert(new Animal("Charlie1090", "Sheep", 11)); // Suggested: Vaccination
                                        dao.insert(new Animal("Molly1091", "Dog", 14)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Luna1092", "Cow", 10)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Jack1093", "Dog", 14)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Molly1094", "Cat", 13)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Lucy1095", "Cow", 9)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Bella1096", "Cow", 1)); // Suggested: Regular health check
                                        dao.insert(new Animal("Lucy1097", "Goat", 6)); // Suggested: Vaccination
                                        dao.insert(new Animal("Lucy1098", "Sheep", 10)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Max1099", "Dog", 9)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Charlie1100", "Goat", 4)); // Suggested: Dental care
                                        dao.insert(new Animal("Buddy1101", "Sheep", 10)); // Suggested: Deworming
                                        dao.insert(new Animal("Buddy1102", "Cow", 4)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Bella1103", "Sheep", 5)); // Suggested: Health Check
                                        dao.insert(new Animal("Lucy1104", "Sheep", 1)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Molly1105", "Cow", 13)); // Suggested: Regular health check
                                        dao.insert(new Animal("Bella1106", "Cat", 3)); // Suggested: Deworming
                                        dao.insert(new Animal("Max1107", "Sheep", 9)); // Suggested: Regular health check
                                        dao.insert(new Animal("Bella1108", "Sheep", 4)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Jack1109", "Cat", 6)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Max1110", "Cow", 11)); // Suggested: Regular health check
                                        dao.insert(new Animal("Charlie1111", "Cow", 13)); // Suggested: Dental care
                                        dao.insert(new Animal("Jack1112", "Goat", 4)); // Suggested: Neutering
                                        dao.insert(new Animal("Daisy1113", "Cow", 12)); // Suggested: Regular health check
                                        dao.insert(new Animal("Luna1114", "Sheep", 13)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Charlie1115", "Goat", 4)); // Suggested: Health Check
                                        dao.insert(new Animal("Bella1116", "Cat", 9)); // Suggested: Deworming
                                        dao.insert(new Animal("Molly1117", "Cow", 2)); // Suggested: Neutering
                                        dao.insert(new Animal("Rocky1118", "Cow", 4)); // Suggested: Neutering
                                        dao.insert(new Animal("Charlie1119", "Goat", 9)); // Suggested: Health Check
                                        dao.insert(new Animal("Molly1120", "Cat", 8)); // Suggested: Health Check
                                        dao.insert(new Animal("Charlie1121", "Dog", 10)); // Suggested: Health Check
                                        dao.insert(new Animal("Buddy1122", "Goat", 5)); // Suggested: Health Check
                                        dao.insert(new Animal("Lucy1123", "Goat", 7)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Daisy1124", "Dog", 4)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Molly1125", "Dog", 10)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Luna1126", "Dog", 1)); // Suggested: Deworming
                                        dao.insert(new Animal("Daisy1127", "Cow", 6)); // Suggested: Neutering
                                        dao.insert(new Animal("Max1128", "Cow", 4)); // Suggested: Dental care
                                        dao.insert(new Animal("Jack1129", "Cat", 7)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Bella1130", "Dog", 2)); // Suggested: Deworming
                                        dao.insert(new Animal("Lucy1131", "Cat", 3)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Luna1132", "Sheep", 4)); // Suggested: Vaccination
                                        dao.insert(new Animal("Rocky1133", "Goat", 8)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Luna1134", "Cat", 11)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Molly1135", "Cat", 3)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Lucy1136", "Goat", 4)); // Suggested: Regular health check
                                        dao.insert(new Animal("Jack1137", "Sheep", 1)); // Suggested: Health Check
                                        dao.insert(new Animal("Buddy1138", "Dog", 11)); // Suggested: Deworming
                                        dao.insert(new Animal("Rocky1139", "Cow", 11)); // Suggested: Health Check
                                        dao.insert(new Animal("Luna1140", "Sheep", 8)); // Suggested: Neutering
                                        dao.insert(new Animal("Rocky1141", "Sheep", 13)); // Suggested: Neutering
                                        dao.insert(new Animal("Charlie1142", "Cat", 6)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Daisy1143", "Goat", 2)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Luna1144", "Cow", 11)); // Suggested: Vaccination
                                        dao.insert(new Animal("Lucy1145", "Sheep", 14)); // Suggested: Health Check
                                        dao.insert(new Animal("Charlie1146", "Cow", 6)); // Suggested: Vaccination
                                        dao.insert(new Animal("Charlie1147", "Goat", 10)); // Suggested: Health Check
                                        dao.insert(new Animal("Rocky1148", "Cow", 13)); // Suggested: Neutering
                                        dao.insert(new Animal("Charlie1149", "Cat", 5)); // Suggested: Regular health check
                                        dao.insert(new Animal("Bella1150", "Dog", 2)); // Suggested: Dental care
                                        dao.insert(new Animal("Molly1151", "Cat", 2)); // Suggested: Regular health check
                                        dao.insert(new Animal("Bella1152", "Dog", 3)); // Suggested: Neutering
                                        dao.insert(new Animal("Molly1153", "Cat", 14)); // Suggested: Deworming
                                        dao.insert(new Animal("Jack1154", "Sheep", 9)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Molly1155", "Cat", 12)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Luna1156", "Goat", 9)); // Suggested: Deworming
                                        dao.insert(new Animal("Luna1157", "Cat", 14)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Charlie1158", "Dog", 2)); // Suggested: Regular health check
                                        dao.insert(new Animal("Charlie1159", "Sheep", 4)); // Suggested: Deworming
                                        dao.insert(new Animal("Charlie1160", "Cat", 12)); // Suggested: Neutering
                                        dao.insert(new Animal("Charlie1161", "Cow", 11)); // Suggested: Vaccination
                                        dao.insert(new Animal("Luna1162", "Goat", 3)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Daisy1163", "Dog", 9)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Jack1164", "Sheep", 7)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Charlie1165", "Cow", 8)); // Suggested: Dental care
                                        dao.insert(new Animal("Lucy1166", "Sheep", 15)); // Suggested: Deworming
                                        dao.insert(new Animal("Max1167", "Goat", 12)); // Suggested: Health Check
                                        dao.insert(new Animal("Lucy1168", "Cow", 14)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Rocky1169", "Goat", 6)); // Suggested: Vaccination
                                        dao.insert(new Animal("Rocky1170", "Dog", 14)); // Suggested: Regular health check
                                        dao.insert(new Animal("Jack1171", "Sheep", 6)); // Suggested: Deworming
                                        dao.insert(new Animal("Rocky1172", "Goat", 7)); // Suggested: Health Check
                                        dao.insert(new Animal("Luna1173", "Dog", 8)); // Suggested: Deworming
                                        dao.insert(new Animal("Molly1174", "Goat", 7)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Charlie1175", "Dog", 13)); // Suggested: Neutering
                                        dao.insert(new Animal("Molly1176", "Dog", 15)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Jack1177", "Sheep", 5)); // Suggested: Vaccination
                                        dao.insert(new Animal("Daisy1178", "Goat", 1)); // Suggested: Deworming
                                        dao.insert(new Animal("Max1179", "Cat", 13)); // Suggested: Neutering
                                        dao.insert(new Animal("Daisy1180", "Dog", 9)); // Suggested: Neutering
                                        dao.insert(new Animal("Rocky1181", "Dog", 4)); // Suggested: Health Check
                                        dao.insert(new Animal("Lucy1182", "Cat", 15)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Luna1183", "Sheep", 12)); // Suggested: Vaccination
                                        dao.insert(new Animal("Luna1184", "Cow", 3)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Jack1185", "Sheep", 8)); // Suggested: Health Check
                                        dao.insert(new Animal("Buddy1186", "Cat", 5)); // Suggested: Health Check
                                        dao.insert(new Animal("Charlie1187", "Cow", 12)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Charlie1188", "Dog", 13)); // Suggested: Health Check
                                        dao.insert(new Animal("Lucy1189", "Dog", 7)); // Suggested: Dental care
                                        dao.insert(new Animal("Lucy1190", "Cow", 1)); // Suggested: Dental care
                                        dao.insert(new Animal("Daisy1191", "Goat", 1)); // Suggested: Deworming
                                        dao.insert(new Animal("Jack1192", "Sheep", 4)); // Suggested: Regular health check
                                        dao.insert(new Animal("Max1193", "Goat", 2)); // Suggested: Regular health check
                                        dao.insert(new Animal("Buddy1194", "Dog", 7)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Daisy1195", "Sheep", 10)); // Suggested: Health Check
                                        dao.insert(new Animal("Lucy1196", "Sheep", 13)); // Suggested: Neutering
                                        dao.insert(new Animal("Jack1197", "Sheep", 6)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Jack1198", "Cow", 3)); // Suggested: Vaccination
                                        dao.insert(new Animal("Max1199", "Sheep", 11)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Buddy1200", "Cat", 7)); // Suggested: Neutering
                                        dao.insert(new Animal("Charlie1201", "Cat", 12)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Lucy1202", "Dog", 5)); // Suggested: Dental care
                                        dao.insert(new Animal("Luna1203", "Cow", 10)); // Suggested: Vaccination
                                        dao.insert(new Animal("Buddy1204", "Cow", 10)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Daisy1205", "Dog", 1)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Bella1206", "Sheep", 6)); // Suggested: Deworming
                                        dao.insert(new Animal("Bella1207", "Sheep", 1)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Luna1208", "Dog", 10)); // Suggested: Dental care
                                        dao.insert(new Animal("Lucy1209", "Goat", 4)); // Suggested: Deworming
                                        dao.insert(new Animal("Rocky1210", "Cat", 1)); // Suggested: Neutering
                                        dao.insert(new Animal("Rocky1211", "Cow", 5)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Molly1212", "Cow", 9)); // Suggested: Regular health check
                                        dao.insert(new Animal("Rocky1213", "Dog", 5)); // Suggested: Neutering
                                        dao.insert(new Animal("Buddy1214", "Sheep", 2)); // Suggested: Dental care
                                        dao.insert(new Animal("Luna1215", "Dog", 6)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Buddy1216", "Cat", 6)); // Suggested: Neutering
                                        dao.insert(new Animal("Jack1217", "Cow", 1)); // Suggested: Vaccination
                                        dao.insert(new Animal("Luna1218", "Goat", 1)); // Suggested: Vaccination
                                        dao.insert(new Animal("Buddy1219", "Sheep", 15)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Charlie1220", "Dog", 15)); // Suggested: Neutering
                                        dao.insert(new Animal("Lucy1221", "Goat", 15)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Bella1222", "Goat", 4)); // Suggested: Dental care
                                        dao.insert(new Animal("Bella1223", "Goat", 11)); // Suggested: Neutering
                                        dao.insert(new Animal("Rocky1224", "Cat", 7)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Max1225", "Cow", 4)); // Suggested: Neutering
                                        dao.insert(new Animal("Luna1226", "Goat", 2)); // Suggested: Neutering
                                        dao.insert(new Animal("Jack1227", "Cow", 9)); // Suggested: Regular health check
                                        dao.insert(new Animal("Molly1228", "Goat", 4)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Jack1229", "Cow", 15)); // Suggested: Dental care
                                        dao.insert(new Animal("Rocky1230", "Dog", 8)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Lucy1231", "Dog", 10)); // Suggested: Dental care
                                        dao.insert(new Animal("Max1232", "Sheep", 1)); // Suggested: Health Check
                                        dao.insert(new Animal("Lucy1233", "Goat", 15)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Charlie1234", "Dog", 3)); // Suggested: Vaccination
                                        dao.insert(new Animal("Jack1235", "Cat", 3)); // Suggested: Health Check
                                        dao.insert(new Animal("Jack1236", "Dog", 8)); // Suggested: Health Check
                                        dao.insert(new Animal("Daisy1237", "Cow", 9)); // Suggested: Neutering
                                        dao.insert(new Animal("Daisy1238", "Cat", 13)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Max1239", "Goat", 2)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Luna1240", "Cow", 12)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Daisy1241", "Cat", 2)); // Suggested: Neutering
                                        dao.insert(new Animal("Buddy1242", "Goat", 2)); // Suggested: Health Check
                                        dao.insert(new Animal("Lucy1243", "Goat", 3)); // Suggested: Regular health check
                                        dao.insert(new Animal("Molly1244", "Dog", 13)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Rocky1245", "Cow", 9)); // Suggested: Vaccination
                                        dao.insert(new Animal("Buddy1246", "Dog", 6)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Lucy1247", "Sheep", 11)); // Suggested: Regular health check
                                        dao.insert(new Animal("Jack1248", "Goat", 15)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Bella1249", "Cat", 8)); // Suggested: Neutering
                                        dao.insert(new Animal("Jack1250", "Cow", 15)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Luna1251", "Dog", 15)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Jack1252", "Cat", 9)); // Suggested: Neutering
                                        dao.insert(new Animal("Luna1253", "Goat", 1)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Lucy1254", "Cow", 10)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Molly1255", "Sheep", 7)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Luna1256", "Cat", 2)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Molly1257", "Dog", 13)); // Suggested: Vaccination
                                        dao.insert(new Animal("Charlie1258", "Goat", 13)); // Suggested: Regular health check
                                        dao.insert(new Animal("Buddy1259", "Dog", 6)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Luna1260", "Cow", 13)); // Suggested: Deworming
                                        dao.insert(new Animal("Jack1261", "Cow", 8)); // Suggested: Dental care
                                        dao.insert(new Animal("Buddy1262", "Cow", 15)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Max1263", "Goat", 12)); // Suggested: Regular health check
                                        dao.insert(new Animal("Luna1264", "Cat", 5)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Buddy1265", "Cat", 8)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Max1266", "Goat", 8)); // Suggested: Vaccination
                                        dao.insert(new Animal("Lucy1267", "Cat", 12)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Luna1268", "Goat", 6)); // Suggested: Vaccination
                                        dao.insert(new Animal("Daisy1269", "Sheep", 5)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Molly1270", "Cow", 8)); // Suggested: Vaccination
                                        dao.insert(new Animal("Charlie1271", "Goat", 15)); // Suggested: Regular health check
                                        dao.insert(new Animal("Luna1272", "Cat", 10)); // Suggested: Regular health check
                                        dao.insert(new Animal("Molly1273", "Goat", 10)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Buddy1274", "Sheep", 15)); // Suggested: Health Check
                                        dao.insert(new Animal("Lucy1275", "Cow", 4)); // Suggested: Neutering
                                        dao.insert(new Animal("Molly1276", "Cat", 12)); // Suggested: Neutering
                                        dao.insert(new Animal("Molly1277", "Cat", 2)); // Suggested: Regular health check
                                        dao.insert(new Animal("Luna1278", "Goat", 14)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Daisy1279", "Goat", 14)); // Suggested: Deworming
                                        dao.insert(new Animal("Rocky1280", "Cow", 5)); // Suggested: Neutering
                                        dao.insert(new Animal("Luna1281", "Dog", 13)); // Suggested: Regular health check
                                        dao.insert(new Animal("Buddy1282", "Goat", 6)); // Suggested: Deworming
                                        dao.insert(new Animal("Lucy1283", "Dog", 9)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Max1284", "Sheep", 2)); // Suggested: Vaccination
                                        dao.insert(new Animal("Luna1285", "Goat", 10)); // Suggested: Deworming
                                        dao.insert(new Animal("Lucy1286", "Goat", 13)); // Suggested: Health Check
                                        dao.insert(new Animal("Jack1287", "Dog", 8)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Jack1288", "Cat", 9)); // Suggested: Neutering
                                        dao.insert(new Animal("Molly1289", "Cow", 15)); // Suggested: Regular health check
                                        dao.insert(new Animal("Buddy1290", "Sheep", 1)); // Suggested: Health Check
                                        dao.insert(new Animal("Bella1291", "Cat", 2)); // Suggested: Health Check
                                        dao.insert(new Animal("Max1292", "Sheep", 9)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Max1293", "Goat", 10)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Luna1294", "Dog", 11)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Jack1295", "Dog", 4)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Charlie1296", "Goat", 7)); // Suggested: Dental care
                                        dao.insert(new Animal("Luna1297", "Cat", 11)); // Suggested: Regular health check
                                        dao.insert(new Animal("Daisy1298", "Goat", 15)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Luna1299", "Goat", 14)); // Suggested: Vaccination
                                        dao.insert(new Animal("Luna1300", "Cow", 14)); // Suggested: Regular health check
                                        dao.insert(new Animal("Max1301", "Dog", 5)); // Suggested: Neutering
                                        dao.insert(new Animal("Daisy1302", "Goat", 14)); // Suggested: Regular health check
                                        dao.insert(new Animal("Bella1303", "Sheep", 4)); // Suggested: Health Check
                                        dao.insert(new Animal("Rocky1304", "Cow", 3)); // Suggested: Health Check
                                        dao.insert(new Animal("Bella1305", "Goat", 10)); // Suggested: Dental care
                                        dao.insert(new Animal("Rocky1306", "Dog", 5)); // Suggested: Regular health check
                                        dao.insert(new Animal("Charlie1307", "Dog", 15)); // Suggested: Dental care
                                        dao.insert(new Animal("Lucy1308", "Dog", 2)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Buddy1309", "Goat", 2)); // Suggested: Deworming
                                        dao.insert(new Animal("Rocky1310", "Cat", 11)); // Suggested: Vaccination
                                        dao.insert(new Animal("Buddy1311", "Sheep", 12)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Rocky1312", "Sheep", 12)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Buddy1313", "Goat", 3)); // Suggested: Dental care
                                        dao.insert(new Animal("Rocky1314", "Cat", 5)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Bella1315", "Goat", 7)); // Suggested: Vaccination
                                        dao.insert(new Animal("Lucy1316", "Cat", 15)); // Suggested: Regular health check
                                        dao.insert(new Animal("Jack1317", "Dog", 8)); // Suggested: Vaccination
                                        dao.insert(new Animal("Buddy1318", "Cat", 7)); // Suggested: Regular health check
                                        dao.insert(new Animal("Molly1319", "Cat", 14)); // Suggested: Dental care
                                        dao.insert(new Animal("Buddy1320", "Goat", 9)); // Suggested: Deworming
                                        dao.insert(new Animal("Charlie1321", "Cow", 9)); // Suggested: Vaccination
                                        dao.insert(new Animal("Bella1322", "Cat", 13)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Charlie1323", "Cow", 12)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Charlie1324", "Cow", 2)); // Suggested: Health Check
                                        dao.insert(new Animal("Lucy1325", "Goat", 15)); // Suggested: Neutering
                                        dao.insert(new Animal("Molly1326", "Cat", 11)); // Suggested: Deworming
                                        dao.insert(new Animal("Buddy1327", "Cow", 5)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Bella1328", "Goat", 3)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Max1329", "Sheep", 2)); // Suggested: Dental care
                                        dao.insert(new Animal("Jack1330", "Sheep", 6)); // Suggested: Vaccination
                                        dao.insert(new Animal("Charlie1331", "Cow", 14)); // Suggested: Regular health check
                                        dao.insert(new Animal("Molly1332", "Cow", 15)); // Suggested: Neutering
                                        dao.insert(new Animal("Buddy1333", "Cow", 12)); // Suggested: Vaccination
                                        dao.insert(new Animal("Daisy1334", "Dog", 1)); // Suggested: Vaccination
                                        dao.insert(new Animal("Jack1335", "Cow", 1)); // Suggested: Health Check
                                        dao.insert(new Animal("Bella1336", "Cow", 7)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Charlie1337", "Goat", 15)); // Suggested: Neutering
                                        dao.insert(new Animal("Molly1338", "Cat", 14)); // Suggested: Vaccination
                                        dao.insert(new Animal("Luna1339", "Goat", 6)); // Suggested: Regular health check
                                        dao.insert(new Animal("Max1340", "Dog", 13)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Charlie1341", "Sheep", 4)); // Suggested: Dental care
                                        dao.insert(new Animal("Bella1342", "Cow", 5)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Buddy1343", "Sheep", 2)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Max1344", "Cat", 1)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Charlie1345", "Cow", 1)); // Suggested: Neutering
                                        dao.insert(new Animal("Molly1346", "Sheep", 12)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Molly1347", "Sheep", 1)); // Suggested: Deworming
                                        dao.insert(new Animal("Lucy1348", "Goat", 8)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Lucy1349", "Cow", 6)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Buddy1350", "Goat", 1)); // Suggested: Neutering
                                        dao.insert(new Animal("Bella1351", "Goat", 4)); // Suggested: Regular health check
                                        dao.insert(new Animal("Buddy1352", "Sheep", 7)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Max1353", "Dog", 14)); // Suggested: Vaccination
                                        dao.insert(new Animal("Charlie1354", "Dog", 6)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Jack1355", "Goat", 10)); // Suggested: Neutering
                                        dao.insert(new Animal("Luna1356", "Sheep", 2)); // Suggested: Dental care
                                        dao.insert(new Animal("Daisy1357", "Goat", 1)); // Suggested: Health Check
                                        dao.insert(new Animal("Molly1358", "Goat", 3)); // Suggested: Vaccination
                                        dao.insert(new Animal("Molly1359", "Cat", 6)); // Suggested: Neutering
                                        dao.insert(new Animal("Luna1360", "Cat", 12)); // Suggested: Deworming
                                        dao.insert(new Animal("Buddy1361", "Goat", 2)); // Suggested: Regular health check
                                        dao.insert(new Animal("Molly1362", "Cat", 7)); // Suggested: Regular health check
                                        dao.insert(new Animal("Buddy1363", "Goat", 13)); // Suggested: Neutering
                                        dao.insert(new Animal("Charlie1364", "Dog", 1)); // Suggested: Dental care
                                        dao.insert(new Animal("Luna1365", "Cow", 10)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Luna1366", "Cow", 15)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Lucy1367", "Dog", 3)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Molly1368", "Sheep", 14)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Jack1369", "Dog", 5)); // Suggested: Vaccination
                                        dao.insert(new Animal("Rocky1370", "Sheep", 4)); // Suggested: Dental care
                                        dao.insert(new Animal("Buddy1371", "Cat", 12)); // Suggested: Regular health check
                                        dao.insert(new Animal("Rocky1372", "Cat", 5)); // Suggested: Vaccination
                                        dao.insert(new Animal("Molly1373", "Sheep", 10)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Lucy1374", "Goat", 9)); // Suggested: Vaccination
                                        dao.insert(new Animal("Molly1375", "Cat", 14)); // Suggested: Health Check
                                        dao.insert(new Animal("Max1376", "Sheep", 3)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Rocky1377", "Sheep", 12)); // Suggested: Vaccination
                                        dao.insert(new Animal("Luna1378", "Dog", 3)); // Suggested: Dental care
                                        dao.insert(new Animal("Charlie1379", "Sheep", 2)); // Suggested: Health Check
                                        dao.insert(new Animal("Bella1380", "Dog", 10)); // Suggested: Dental care
                                        dao.insert(new Animal("Buddy1381", "Dog", 12)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Buddy1382", "Goat", 13)); // Suggested: Regular health check
                                        dao.insert(new Animal("Daisy1383", "Cow", 15)); // Suggested: Vaccination
                                        dao.insert(new Animal("Bella1384", "Cow", 13)); // Suggested: Health Check
                                        dao.insert(new Animal("Molly1385", "Dog", 10)); // Suggested: Health Check
                                        dao.insert(new Animal("Rocky1386", "Sheep", 5)); // Suggested: Health Check
                                        dao.insert(new Animal("Bella1387", "Dog", 4)); // Suggested: Regular health check
                                        dao.insert(new Animal("Max1388", "Goat", 13)); // Suggested: Neutering
                                        dao.insert(new Animal("Molly1389", "Cat", 1)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Rocky1390", "Dog", 14)); // Suggested: Dental care
                                        dao.insert(new Animal("Molly1391", "Dog", 4)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Bella1392", "Dog", 1)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Jack1393", "Cow", 8)); // Suggested: Deworming
                                        dao.insert(new Animal("Max1394", "Cat", 5)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Bella1395", "Cat", 9)); // Suggested: Vaccination
                                        dao.insert(new Animal("Buddy1396", "Sheep", 11)); // Suggested: Vaccination
                                        dao.insert(new Animal("Buddy1397", "Sheep", 6)); // Suggested: Vaccination
                                        dao.insert(new Animal("Charlie1398", "Cat", 3)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Charlie1399", "Cat", 2)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Luna1400", "Sheep", 5)); // Suggested: Regular health check
                                        dao.insert(new Animal("Max1401", "Goat", 11)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Jack1402", "Goat", 11)); // Suggested: Neutering
                                        dao.insert(new Animal("Max1403", "Dog", 8)); // Suggested: Deworming
                                        dao.insert(new Animal("Lucy1404", "Dog", 12)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Buddy1405", "Sheep", 4)); // Suggested: Health Check
                                        dao.insert(new Animal("Max1406", "Dog", 15)); // Suggested: Dental care
                                        dao.insert(new Animal("Max1407", "Goat", 11)); // Suggested: Regular health check
                                        dao.insert(new Animal("Charlie1408", "Cat", 9)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Lucy1409", "Goat", 15)); // Suggested: Neutering
                                        dao.insert(new Animal("Molly1410", "Cow", 4)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Lucy1411", "Cat", 15)); // Suggested: Neutering
                                        dao.insert(new Animal("Molly1412", "Dog", 3)); // Suggested: Health Check
                                        dao.insert(new Animal("Max1413", "Cow", 3)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Jack1414", "Cow", 1)); // Suggested: Regular health check
                                        dao.insert(new Animal("Max1415", "Cow", 13)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Charlie1416", "Dog", 2)); // Suggested: Dental care
                                        dao.insert(new Animal("Bella1417", "Goat", 10)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Molly1418", "Sheep", 5)); // Suggested: Health Check
                                        dao.insert(new Animal("Lucy1419", "Sheep", 1)); // Suggested: Health Check
                                        dao.insert(new Animal("Molly1420", "Cow", 7)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Rocky1421", "Cow", 6)); // Suggested: Neutering
                                        dao.insert(new Animal("Daisy1422", "Cow", 1)); // Suggested: Regular health check
                                        dao.insert(new Animal("Luna1423", "Goat", 5)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Lucy1424", "Dog", 11)); // Suggested: Vaccination
                                        dao.insert(new Animal("Bella1425", "Cow", 6)); // Suggested: Vaccination
                                        dao.insert(new Animal("Charlie1426", "Cow", 10)); // Suggested: Vaccination
                                        dao.insert(new Animal("Rocky1427", "Dog", 12)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Lucy1428", "Cat", 12)); // Suggested: Neutering
                                        dao.insert(new Animal("Jack1429", "Dog", 2)); // Suggested: Neutering
                                        dao.insert(new Animal("Daisy1430", "Sheep", 6)); // Suggested: Vaccination
                                        dao.insert(new Animal("Jack1431", "Goat", 13)); // Suggested: Regular health check
                                        dao.insert(new Animal("Rocky1432", "Goat", 5)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Molly1433", "Cow", 15)); // Suggested: Vaccination
                                        dao.insert(new Animal("Daisy1434", "Sheep", 13)); // Suggested: Dental care
                                        dao.insert(new Animal("Max1435", "Cat", 6)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Daisy1436", "Cat", 6)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Lucy1437", "Goat", 5)); // Suggested: Deworming
                                        dao.insert(new Animal("Bella1438", "Goat", 11)); // Suggested: Deworming
                                        dao.insert(new Animal("Lucy1439", "Sheep", 8)); // Suggested: Neutering
                                        dao.insert(new Animal("Charlie1440", "Cow", 15)); // Suggested: Vaccination
                                        dao.insert(new Animal("Molly1441", "Dog", 13)); // Suggested: Deworming
                                        dao.insert(new Animal("Rocky1442", "Sheep", 2)); // Suggested: Health Check
                                        dao.insert(new Animal("Rocky1443", "Cat", 13)); // Suggested: Vaccination
                                        dao.insert(new Animal("Luna1444", "Cow", 9)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Molly1445", "Goat", 6)); // Suggested: Regular health check
                                        dao.insert(new Animal("Luna1446", "Sheep", 13)); // Suggested: Health Check
                                        dao.insert(new Animal("Luna1447", "Sheep", 14)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Charlie1448", "Sheep", 8)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Luna1449", "Dog", 5)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Charlie1450", "Cow", 7)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Bella1451", "Cow", 10)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Lucy1452", "Sheep", 9)); // Suggested: Neutering
                                        dao.insert(new Animal("Bella1453", "Cat", 2)); // Suggested: Neutering
                                        dao.insert(new Animal("Charlie1454", "Dog", 8)); // Suggested: Deworming
                                        dao.insert(new Animal("Bella1455", "Goat", 4)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Rocky1456", "Cat", 2)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Bella1457", "Cow", 9)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Molly1458", "Cow", 3)); // Suggested: Vaccination
                                        dao.insert(new Animal("Bella1459", "Goat", 9)); // Suggested: Health Check
                                        dao.insert(new Animal("Bella1460", "Cow", 2)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Luna1461", "Dog", 8)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Molly1462", "Dog", 11)); // Suggested: Dental care
                                        dao.insert(new Animal("Rocky1463", "Cow", 3)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Luna1464", "Cow", 3)); // Suggested: Neutering
                                        dao.insert(new Animal("Luna1465", "Cow", 1)); // Suggested: Dental care
                                        dao.insert(new Animal("Lucy1466", "Cow", 15)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Rocky1467", "Goat", 11)); // Suggested: Deworming
                                        dao.insert(new Animal("Bella1468", "Cow", 5)); // Suggested: Regular health check
                                        dao.insert(new Animal("Molly1469", "Dog", 2)); // Suggested: Neutering
                                        dao.insert(new Animal("Jack1470", "Goat", 14)); // Suggested: Deworming
                                        dao.insert(new Animal("Molly1471", "Dog", 9)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Luna1472", "Sheep", 14)); // Suggested: Regular health check
                                        dao.insert(new Animal("Max1473", "Goat", 10)); // Suggested: Health Check
                                        dao.insert(new Animal("Bella1474", "Goat", 12)); // Suggested: Vaccination
                                        dao.insert(new Animal("Buddy1475", "Cat", 15)); // Suggested: Deworming
                                        dao.insert(new Animal("Max1476", "Cow", 11)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Max1477", "Goat", 3)); // Suggested: Health Check
                                        dao.insert(new Animal("Charlie1478", "Cow", 4)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Charlie1479", "Dog", 8)); // Suggested: Deworming
                                        dao.insert(new Animal("Bella1480", "Goat", 6)); // Suggested: Health Check
                                        dao.insert(new Animal("Molly1481", "Dog", 14)); // Suggested: Regular health check
                                        dao.insert(new Animal("Rocky1482", "Sheep", 9)); // Suggested: Regular health check
                                        dao.insert(new Animal("Charlie1483", "Dog", 13)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Molly1484", "Dog", 10)); // Suggested: Deworming
                                        dao.insert(new Animal("Buddy1485", "Dog", 1)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Charlie1486", "Cow", 7)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Molly1487", "Sheep", 13)); // Suggested: Neutering
                                        dao.insert(new Animal("Max1488", "Sheep", 1)); // Suggested: Regular health check
                                        dao.insert(new Animal("Jack1489", "Goat", 15)); // Suggested: Neutering
                                        dao.insert(new Animal("Bella1490", "Goat", 8)); // Suggested: Vaccination
                                        dao.insert(new Animal("Lucy1491", "Goat", 2)); // Suggested: Health Check
                                        dao.insert(new Animal("Luna1492", "Cow", 2)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Charlie1493", "Dog", 15)); // Suggested: Regular health check
                                        dao.insert(new Animal("Lucy1494", "Cow", 1)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Buddy1495", "Goat", 6)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Rocky1496", "Sheep", 14)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Max1497", "Cow", 15)); // Suggested: Regular health check
                                        dao.insert(new Animal("Max1498", "Cat", 2)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Daisy1499", "Sheep", 9)); // Suggested: Health Check
                                        dao.insert(new Animal("Bella1500", "Goat", 11)); // Suggested: Health Check
                                        dao.insert(new Animal("Molly1501", "Cat", 12)); // Suggested: Vaccination
                                        dao.insert(new Animal("Jack1502", "Sheep", 9)); // Suggested: Regular health check
                                        dao.insert(new Animal("Buddy1503", "Goat", 10)); // Suggested: Neutering
                                        dao.insert(new Animal("Lucy1504", "Dog", 13)); // Suggested: Vaccination
                                        dao.insert(new Animal("Molly1505", "Dog", 2)); // Suggested: Dental care
                                        dao.insert(new Animal("Lucy1506", "Sheep", 14)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Rocky1507", "Goat", 13)); // Suggested: Regular health check
                                        dao.insert(new Animal("Buddy1508", "Cat", 6)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Charlie1509", "Goat", 11)); // Suggested: Dental care
                                        dao.insert(new Animal("Charlie1510", "Goat", 15)); // Suggested: Vaccination
                                        dao.insert(new Animal("Jack1511", "Goat", 11)); // Suggested: Deworming
                                        dao.insert(new Animal("Lucy1512", "Sheep", 10)); // Suggested: Vaccination
                                        dao.insert(new Animal("Charlie1513", "Sheep", 10)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Charlie1514", "Cow", 14)); // Suggested: Deworming
                                        dao.insert(new Animal("Luna1515", "Cow", 6)); // Suggested: Deworming
                                        dao.insert(new Animal("Bella1516", "Dog", 5)); // Suggested: Dental care
                                        dao.insert(new Animal("Luna1517", "Goat", 12)); // Suggested: Deworming
                                        dao.insert(new Animal("Daisy1518", "Dog", 13)); // Suggested: Neutering
                                        dao.insert(new Animal("Rocky1519", "Cow", 12)); // Suggested: Regular health check
                                        dao.insert(new Animal("Max1520", "Dog", 4)); // Suggested: Deworming
                                        dao.insert(new Animal("Rocky1521", "Dog", 12)); // Suggested: Dental care
                                        dao.insert(new Animal("Daisy1522", "Goat", 15)); // Suggested: Regular health check
                                        dao.insert(new Animal("Charlie1523", "Dog", 14)); // Suggested: Vaccination
                                        dao.insert(new Animal("Bella1524", "Cow", 8)); // Suggested: Health Check
                                        dao.insert(new Animal("Rocky1525", "Sheep", 8)); // Suggested: Health Check
                                        dao.insert(new Animal("Luna1526", "Cow", 6)); // Suggested: Health Check
                                        dao.insert(new Animal("Max1527", "Goat", 13)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Bella1528", "Sheep", 2)); // Suggested: Dental care
                                        dao.insert(new Animal("Molly1529", "Cow", 15)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Molly1530", "Sheep", 3)); // Suggested: Deworming
                                        dao.insert(new Animal("Charlie1531", "Sheep", 5)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Bella1532", "Cow", 13)); // Suggested: Dental care
                                        dao.insert(new Animal("Rocky1533", "Cat", 4)); // Suggested: Regular health check
                                        dao.insert(new Animal("Jack1534", "Cat", 5)); // Suggested: Vaccination
                                        dao.insert(new Animal("Jack1535", "Cat", 8)); // Suggested: Neutering
                                        dao.insert(new Animal("Buddy1536", "Goat", 6)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Rocky1537", "Sheep", 6)); // Suggested: Deworming
                                        dao.insert(new Animal("Max1538", "Dog", 2)); // Suggested: Deworming
                                        dao.insert(new Animal("Luna1539", "Sheep", 4)); // Suggested: Health Check
                                        dao.insert(new Animal("Jack1540", "Cat", 10)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Buddy1541", "Sheep", 2)); // Suggested: Health Check
                                        dao.insert(new Animal("Lucy1542", "Goat", 15)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Bella1543", "Cow", 6)); // Suggested: Dental care
                                        dao.insert(new Animal("Jack1544", "Cat", 11)); // Suggested: Dental care
                                        dao.insert(new Animal("Bella1545", "Sheep", 12)); // Suggested: Deworming
                                        dao.insert(new Animal("Lucy1546", "Cat", 15)); // Suggested: Deworming
                                        dao.insert(new Animal("Molly1547", "Sheep", 3)); // Suggested: Dental care
                                        dao.insert(new Animal("Lucy1548", "Cat", 7)); // Suggested: Health Check
                                        dao.insert(new Animal("Daisy1549", "Goat", 13)); // Suggested: Dental care
                                        dao.insert(new Animal("Jack1550", "Sheep", 2)); // Suggested: Regular health check
                                        dao.insert(new Animal("Charlie1551", "Cat", 6)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Lucy1552", "Cat", 13)); // Suggested: Deworming
                                        dao.insert(new Animal("Lucy1553", "Cow", 4)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Charlie1554", "Cow", 5)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Buddy1555", "Goat", 4)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Charlie1556", "Sheep", 3)); // Suggested: Neutering
                                        dao.insert(new Animal("Luna1557", "Cow", 14)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Buddy1558", "Cat", 7)); // Suggested: Neutering
                                        dao.insert(new Animal("Max1559", "Goat", 7)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Charlie1560", "Cat", 7)); // Suggested: Dental care
                                        dao.insert(new Animal("Charlie1561", "Cow", 10)); // Suggested: Neutering
                                        dao.insert(new Animal("Molly1562", "Cat", 15)); // Suggested: Dental care
                                        dao.insert(new Animal("Rocky1563", "Sheep", 12)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Lucy1564", "Dog", 14)); // Suggested: Vaccination
                                        dao.insert(new Animal("Charlie1565", "Goat", 7)); // Suggested: Regular health check
                                        dao.insert(new Animal("Jack1566", "Cow", 15)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Lucy1567", "Goat", 5)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Luna1568", "Goat", 9)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Luna1569", "Goat", 10)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Daisy1570", "Dog", 13)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Daisy1571", "Cow", 15)); // Suggested: Regular health check
                                        dao.insert(new Animal("Buddy1572", "Dog", 9)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Bella1573", "Goat", 10)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Max1574", "Cat", 2)); // Suggested: Vaccination
                                        dao.insert(new Animal("Molly1575", "Sheep", 3)); // Suggested: Neutering
                                        dao.insert(new Animal("Luna1576", "Goat", 8)); // Suggested: Neutering
                                        dao.insert(new Animal("Rocky1577", "Cow", 10)); // Suggested: Neutering
                                        dao.insert(new Animal("Molly1578", "Cat", 10)); // Suggested: Deworming
                                        dao.insert(new Animal("Bella1579", "Cat", 9)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Daisy1580", "Dog", 9)); // Suggested: Deworming
                                        dao.insert(new Animal("Molly1581", "Cat", 2)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Jack1582", "Sheep", 6)); // Suggested: Regular health check
                                        dao.insert(new Animal("Luna1583", "Cat", 8)); // Suggested: Dental care
                                        dao.insert(new Animal("Luna1584", "Cow", 10)); // Suggested: Health Check
                                        dao.insert(new Animal("Jack1585", "Dog", 7)); // Suggested: Vaccination
                                        dao.insert(new Animal("Bella1586", "Sheep", 5)); // Suggested: Dental care
                                        dao.insert(new Animal("Daisy1587", "Cow", 7)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Bella1588", "Sheep", 15)); // Suggested: Deworming
                                        dao.insert(new Animal("Charlie1589", "Cat", 2)); // Suggested: Regular health check
                                        dao.insert(new Animal("Rocky1590", "Cow", 13)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Jack1591", "Cow", 14)); // Suggested: Health Check
                                        dao.insert(new Animal("Buddy1592", "Goat", 5)); // Suggested: Regular health check
                                        dao.insert(new Animal("Jack1593", "Goat", 2)); // Suggested: Dental care
                                        dao.insert(new Animal("Bella1594", "Goat", 2)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Molly1595", "Dog", 5)); // Suggested: Vaccination
                                        dao.insert(new Animal("Daisy1596", "Goat", 6)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Max1597", "Sheep", 2)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Luna1598", "Sheep", 12)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Jack1599", "Sheep", 8)); // Suggested: Deworming
                                        dao.insert(new Animal("Luna1600", "Cow", 7)); // Suggested: Neutering
                                        dao.insert(new Animal("Luna1601", "Cow", 8)); // Suggested: Neutering
                                        dao.insert(new Animal("Molly1602", "Sheep", 6)); // Suggested: Vaccination
                                        dao.insert(new Animal("Buddy1603", "Dog", 7)); // Suggested: Health Check
                                        dao.insert(new Animal("Luna1604", "Cow", 1)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Charlie1605", "Cow", 10)); // Suggested: Vaccination
                                        dao.insert(new Animal("Max1606", "Dog", 12)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Jack1607", "Cat", 3)); // Suggested: Health Check
                                        dao.insert(new Animal("Luna1608", "Cow", 14)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Rocky1609", "Cow", 9)); // Suggested: Vaccination
                                        dao.insert(new Animal("Luna1610", "Dog", 9)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Molly1611", "Dog", 1)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Luna1612", "Goat", 11)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Max1613", "Dog", 6)); // Suggested: Dental care
                                        dao.insert(new Animal("Charlie1614", "Sheep", 9)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Max1615", "Sheep", 15)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Lucy1616", "Cat", 5)); // Suggested: Neutering
                                        dao.insert(new Animal("Lucy1617", "Goat", 8)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Bella1618", "Cow", 13)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Buddy1619", "Goat", 8)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Buddy1620", "Sheep", 5)); // Suggested: Vaccination
                                        dao.insert(new Animal("Buddy1621", "Goat", 2)); // Suggested: Deworming
                                        dao.insert(new Animal("Lucy1622", "Cow", 3)); // Suggested: Health Check
                                        dao.insert(new Animal("Molly1623", "Cow", 13)); // Suggested: Regular health check
                                        dao.insert(new Animal("Lucy1624", "Sheep", 11)); // Suggested: Vaccination
                                        dao.insert(new Animal("Jack1625", "Cat", 11)); // Suggested: Health Check
                                        dao.insert(new Animal("Luna1626", "Cat", 8)); // Suggested: Dental care
                                        dao.insert(new Animal("Luna1627", "Goat", 2)); // Suggested: Deworming
                                        dao.insert(new Animal("Rocky1628", "Goat", 1)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Lucy1629", "Cat", 5)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Charlie1630", "Dog", 12)); // Suggested: Dental care
                                        dao.insert(new Animal("Rocky1631", "Dog", 4)); // Suggested: Vaccination
                                        dao.insert(new Animal("Bella1632", "Goat", 6)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Rocky1633", "Cow", 5)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Lucy1634", "Cat", 13)); // Suggested: Regular health check
                                        dao.insert(new Animal("Rocky1635", "Cat", 4)); // Suggested: Regular health check
                                        dao.insert(new Animal("Lucy1636", "Sheep", 3)); // Suggested: Health Check
                                        dao.insert(new Animal("Molly1637", "Cow", 2)); // Suggested: Health Check
                                        dao.insert(new Animal("Charlie1638", "Goat", 8)); // Suggested: Vaccination
                                        dao.insert(new Animal("Bella1639", "Goat", 7)); // Suggested: Dental care
                                        dao.insert(new Animal("Jack1640", "Cow", 5)); // Suggested: Vaccination
                                        dao.insert(new Animal("Charlie1641", "Cow", 12)); // Suggested: Regular health check
                                        dao.insert(new Animal("Max1642", "Cat", 5)); // Suggested: Dental care
                                        dao.insert(new Animal("Max1643", "Cow", 4)); // Suggested: Neutering
                                        dao.insert(new Animal("Bella1644", "Cow", 7)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Jack1645", "Cow", 13)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Charlie1646", "Dog", 4)); // Suggested: Health Check
                                        dao.insert(new Animal("Luna1647", "Cow", 9)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Jack1648", "Sheep", 7)); // Suggested: Deworming
                                        dao.insert(new Animal("Jack1649", "Dog", 4)); // Suggested: Dental care
                                        dao.insert(new Animal("Jack1650", "Sheep", 6)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Buddy1651", "Cat", 5)); // Suggested: Health Check
                                        dao.insert(new Animal("Rocky1652", "Goat", 11)); // Suggested: Health Check
                                        dao.insert(new Animal("Lucy1653", "Cow", 4)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Molly1654", "Dog", 2)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Rocky1655", "Cow", 12)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Max1656", "Dog", 7)); // Suggested: Deworming
                                        dao.insert(new Animal("Rocky1657", "Cow", 14)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Max1658", "Goat", 8)); // Suggested: Neutering
                                        dao.insert(new Animal("Molly1659", "Sheep", 12)); // Suggested: Deworming
                                        dao.insert(new Animal("Max1660", "Goat", 7)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Max1661", "Sheep", 10)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Daisy1662", "Cat", 14)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Rocky1663", "Cat", 6)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Molly1664", "Sheep", 8)); // Suggested: Deworming
                                        dao.insert(new Animal("Rocky1665", "Cat", 7)); // Suggested: Vaccination
                                        dao.insert(new Animal("Rocky1666", "Cat", 12)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Jack1667", "Cat", 8)); // Suggested: Deworming
                                        dao.insert(new Animal("Bella1668", "Goat", 5)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Bella1669", "Cow", 13)); // Suggested: Vaccination
                                        dao.insert(new Animal("Bella1670", "Cow", 6)); // Suggested: Regular health check
                                        dao.insert(new Animal("Charlie1671", "Sheep", 6)); // Suggested: Dental care
                                        dao.insert(new Animal("Lucy1672", "Dog", 1)); // Suggested: Regular health check
                                        dao.insert(new Animal("Rocky1673", "Goat", 14)); // Suggested: Neutering
                                        dao.insert(new Animal("Luna1674", "Sheep", 13)); // Suggested: Dental care
                                        dao.insert(new Animal("Buddy1675", "Goat", 4)); // Suggested: Vaccination
                                        dao.insert(new Animal("Daisy1676", "Dog", 14)); // Suggested: Deworming
                                        dao.insert(new Animal("Max1677", "Dog", 10)); // Suggested: Dental care
                                        dao.insert(new Animal("Charlie1678", "Cow", 6)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Buddy1679", "Cow", 7)); // Suggested: Neutering
                                        dao.insert(new Animal("Buddy1680", "Sheep", 5)); // Suggested: Dental care
                                        dao.insert(new Animal("Luna1681", "Sheep", 3)); // Suggested: Dental care
                                        dao.insert(new Animal("Lucy1682", "Cat", 14)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Lucy1683", "Cat", 12)); // Suggested: Regular health check
                                        dao.insert(new Animal("Max1684", "Dog", 10)); // Suggested: Dental care
                                        dao.insert(new Animal("Daisy1685", "Sheep", 15)); // Suggested: Neutering
                                        dao.insert(new Animal("Jack1686", "Cat", 6)); // Suggested: Vaccination
                                        dao.insert(new Animal("Bella1687", "Sheep", 4)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Molly1688", "Dog", 1)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Molly1689", "Goat", 4)); // Suggested: Health Check
                                        dao.insert(new Animal("Luna1690", "Goat", 13)); // Suggested: Deworming
                                        dao.insert(new Animal("Luna1691", "Goat", 4)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Lucy1692", "Sheep", 7)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Buddy1693", "Cow", 3)); // Suggested: Deworming
                                        dao.insert(new Animal("Lucy1694", "Sheep", 2)); // Suggested: Regular health check
                                        dao.insert(new Animal("Bella1695", "Sheep", 8)); // Suggested: Dental care
                                        dao.insert(new Animal("Luna1696", "Dog", 1)); // Suggested: Health Check
                                        dao.insert(new Animal("Molly1697", "Dog", 14)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Luna1698", "Sheep", 13)); // Suggested: Deworming
                                        dao.insert(new Animal("Bella1699", "Goat", 3)); // Suggested: Regular health check
                                        dao.insert(new Animal("Daisy1700", "Cow", 1)); // Suggested: Vaccination
                                        dao.insert(new Animal("Charlie1701", "Cat", 10)); // Suggested: Regular health check
                                        dao.insert(new Animal("Bella1702", "Cow", 8)); // Suggested: Deworming
                                        dao.insert(new Animal("Luna1703", "Cow", 6)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Molly1704", "Dog", 5)); // Suggested: Regular health check
                                        dao.insert(new Animal("Jack1705", "Cat", 8)); // Suggested: Dental care
                                        dao.insert(new Animal("Luna1706", "Sheep", 13)); // Suggested: Health Check
                                        dao.insert(new Animal("Molly1707", "Goat", 7)); // Suggested: Deworming
                                        dao.insert(new Animal("Jack1708", "Sheep", 7)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Bella1709", "Cat", 2)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Daisy1710", "Sheep", 10)); // Suggested: Health Check
                                        dao.insert(new Animal("Molly1711", "Goat", 1)); // Suggested: Dental care
                                        dao.insert(new Animal("Jack1712", "Sheep", 5)); // Suggested: Health Check
                                        dao.insert(new Animal("Daisy1713", "Sheep", 12)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Bella1714", "Cow", 7)); // Suggested: Vaccination
                                        dao.insert(new Animal("Rocky1715", "Sheep", 11)); // Suggested: Dental care
                                        dao.insert(new Animal("Charlie1716", "Cat", 11)); // Suggested: Regular health check
                                        dao.insert(new Animal("Charlie1717", "Cat", 13)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Daisy1718", "Sheep", 8)); // Suggested: Vaccination
                                        dao.insert(new Animal("Daisy1719", "Cow", 8)); // Suggested: Vaccination
                                        dao.insert(new Animal("Luna1720", "Cat", 6)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Lucy1721", "Dog", 9)); // Suggested: Vaccination
                                        dao.insert(new Animal("Molly1722", "Dog", 13)); // Suggested: Regular health check
                                        dao.insert(new Animal("Max1723", "Cat", 2)); // Suggested: Neutering
                                        dao.insert(new Animal("Rocky1724", "Cow", 2)); // Suggested: Deworming
                                        dao.insert(new Animal("Buddy1725", "Cat", 4)); // Suggested: Regular health check
                                        dao.insert(new Animal("Max1726", "Goat", 8)); // Suggested: Neutering
                                        dao.insert(new Animal("Rocky1727", "Sheep", 1)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Lucy1728", "Cow", 9)); // Suggested: Regular health check
                                        dao.insert(new Animal("Rocky1729", "Dog", 12)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Lucy1730", "Dog", 2)); // Suggested: Health Check
                                        dao.insert(new Animal("Charlie1731", "Cow", 5)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Max1732", "Dog", 12)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Luna1733", "Cow", 8)); // Suggested: Neutering
                                        dao.insert(new Animal("Rocky1734", "Cat", 7)); // Suggested: Neutering
                                        dao.insert(new Animal("Molly1735", "Sheep", 12)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Rocky1736", "Dog", 6)); // Suggested: Health Check
                                        dao.insert(new Animal("Jack1737", "Cat", 12)); // Suggested: Regular health check
                                        dao.insert(new Animal("Molly1738", "Dog", 1)); // Suggested: Dental care
                                        dao.insert(new Animal("Jack1739", "Cow", 9)); // Suggested: Dental care
                                        dao.insert(new Animal("Luna1740", "Sheep", 5)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Luna1741", "Dog", 4)); // Suggested: Deworming
                                        dao.insert(new Animal("Lucy1742", "Goat", 1)); // Suggested: Vaccination
                                        dao.insert(new Animal("Luna1743", "Goat", 15)); // Suggested: Regular health check
                                        dao.insert(new Animal("Buddy1744", "Dog", 9)); // Suggested: Health Check
                                        dao.insert(new Animal("Molly1745", "Cat", 6)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Bella1746", "Dog", 4)); // Suggested: Neutering
                                        dao.insert(new Animal("Luna1747", "Sheep", 9)); // Suggested: Vaccination
                                        dao.insert(new Animal("Rocky1748", "Sheep", 9)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Rocky1749", "Dog", 13)); // Suggested: Vaccination
                                        dao.insert(new Animal("Jack1750", "Goat", 3)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Rocky1751", "Cat", 1)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Buddy1752", "Dog", 6)); // Suggested: Health Check
                                        dao.insert(new Animal("Charlie1753", "Dog", 10)); // Suggested: Health Check
                                        dao.insert(new Animal("Daisy1754", "Cat", 15)); // Suggested: Deworming
                                        dao.insert(new Animal("Molly1755", "Dog", 1)); // Suggested: Regular health check
                                        dao.insert(new Animal("Lucy1756", "Dog", 2)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Lucy1757", "Goat", 4)); // Suggested: Health Check
                                        dao.insert(new Animal("Luna1758", "Cow", 15)); // Suggested: Vaccination
                                        dao.insert(new Animal("Luna1759", "Goat", 3)); // Suggested: Regular health check
                                        dao.insert(new Animal("Daisy1760", "Dog", 8)); // Suggested: Health Check
                                        dao.insert(new Animal("Charlie1761", "Dog", 7)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Bella1762", "Dog", 1)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Buddy1763", "Cat", 12)); // Suggested: Neutering
                                        dao.insert(new Animal("Max1764", "Goat", 11)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Max1765", "Goat", 7)); // Suggested: Dental care
                                        dao.insert(new Animal("Jack1766", "Goat", 5)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Jack1767", "Dog", 9)); // Suggested: Neutering
                                        dao.insert(new Animal("Max1768", "Sheep", 7)); // Suggested: Health Check
                                        dao.insert(new Animal("Molly1769", "Dog", 2)); // Suggested: Health Check
                                        dao.insert(new Animal("Jack1770", "Cow", 2)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Bella1771", "Cow", 4)); // Suggested: Dental care
                                        dao.insert(new Animal("Daisy1772", "Cat", 9)); // Suggested: Health Check
                                        dao.insert(new Animal("Daisy1773", "Cat", 15)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Daisy1774", "Sheep", 5)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Jack1775", "Sheep", 7)); // Suggested: Vaccination
                                        dao.insert(new Animal("Max1776", "Goat", 1)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Luna1777", "Sheep", 11)); // Suggested: Neutering
                                        dao.insert(new Animal("Max1778", "Sheep", 13)); // Suggested: Vaccination
                                        dao.insert(new Animal("Buddy1779", "Dog", 7)); // Suggested: Deworming
                                        dao.insert(new Animal("Daisy1780", "Dog", 7)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Charlie1781", "Sheep", 11)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Lucy1782", "Dog", 8)); // Suggested: Neutering
                                        dao.insert(new Animal("Jack1783", "Dog", 11)); // Suggested: Dental care
                                        dao.insert(new Animal("Lucy1784", "Goat", 8)); // Suggested: Vaccination
                                        dao.insert(new Animal("Daisy1785", "Cat", 12)); // Suggested: Neutering
                                        dao.insert(new Animal("Rocky1786", "Dog", 4)); // Suggested: Dental care
                                        dao.insert(new Animal("Lucy1787", "Dog", 5)); // Suggested: Health Check
                                        dao.insert(new Animal("Max1788", "Cow", 11)); // Suggested: Regular health check
                                        dao.insert(new Animal("Max1789", "Dog", 13)); // Suggested: Neutering
                                        dao.insert(new Animal("Max1790", "Cat", 8)); // Suggested: Neutering
                                        dao.insert(new Animal("Molly1791", "Cow", 4)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Rocky1792", "Cat", 7)); // Suggested: Dental care
                                        dao.insert(new Animal("Buddy1793", "Cat", 1)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Charlie1794", "Dog", 5)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Buddy1795", "Cow", 11)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Jack1796", "Goat", 9)); // Suggested: Neutering
                                        dao.insert(new Animal("Charlie1797", "Sheep", 11)); // Suggested: Vaccination
                                        dao.insert(new Animal("Rocky1798", "Sheep", 6)); // Suggested: Regular health check
                                        dao.insert(new Animal("Bella1799", "Cat", 10)); // Suggested: Regular health check
                                        dao.insert(new Animal("Max1800", "Cow", 10)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Lucy1801", "Cow", 9)); // Suggested: Vaccination
                                        dao.insert(new Animal("Buddy1802", "Goat", 12)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Charlie1803", "Cat", 7)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Daisy1804", "Goat", 5)); // Suggested: Dental care
                                        dao.insert(new Animal("Buddy1805", "Cat", 2)); // Suggested: Deworming
                                        dao.insert(new Animal("Max1806", "Sheep", 9)); // Suggested: Health Check
                                        dao.insert(new Animal("Rocky1807", "Sheep", 8)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Rocky1808", "Sheep", 14)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Luna1809", "Dog", 7)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Daisy1810", "Cat", 14)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Rocky1811", "Dog", 11)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Max1812", "Goat", 11)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Molly1813", "Cat", 13)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Charlie1814", "Sheep", 12)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Jack1815", "Dog", 5)); // Suggested: Deworming
                                        dao.insert(new Animal("Luna1816", "Cow", 10)); // Suggested: Regular health check
                                        dao.insert(new Animal("Daisy1817", "Sheep", 13)); // Suggested: Health Check
                                        dao.insert(new Animal("Lucy1818", "Cat", 11)); // Suggested: Health Check
                                        dao.insert(new Animal("Max1819", "Cat", 14)); // Suggested: Deworming
                                        dao.insert(new Animal("Daisy1820", "Cat", 5)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Charlie1821", "Cow", 5)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Bella1822", "Cat", 7)); // Suggested: Dental care
                                        dao.insert(new Animal("Lucy1823", "Dog", 4)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Jack1824", "Sheep", 2)); // Suggested: Regular health check
                                        dao.insert(new Animal("Buddy1825", "Dog", 1)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Luna1826", "Sheep", 1)); // Suggested: Vaccination
                                        dao.insert(new Animal("Rocky1827", "Dog", 14)); // Suggested: Dental care
                                        dao.insert(new Animal("Molly1828", "Cat", 10)); // Suggested: Health Check
                                        dao.insert(new Animal("Bella1829", "Sheep", 12)); // Suggested: Neutering
                                        dao.insert(new Animal("Lucy1830", "Sheep", 12)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Charlie1831", "Goat", 12)); // Suggested: Dental care
                                        dao.insert(new Animal("Daisy1832", "Sheep", 2)); // Suggested: Vaccination
                                        dao.insert(new Animal("Buddy1833", "Dog", 9)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Bella1834", "Cow", 15)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Lucy1835", "Cow", 8)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Daisy1836", "Sheep", 15)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Molly1837", "Sheep", 13)); // Suggested: Vaccination
                                        dao.insert(new Animal("Charlie1838", "Cat", 3)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Bella1839", "Cow", 3)); // Suggested: Health Check
                                        dao.insert(new Animal("Daisy1840", "Goat", 8)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Max1841", "Sheep", 8)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Max1842", "Cat", 13)); // Suggested: Neutering
                                        dao.insert(new Animal("Luna1843", "Goat", 3)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Charlie1844", "Goat", 11)); // Suggested: Regular health check
                                        dao.insert(new Animal("Rocky1845", "Cat", 10)); // Suggested: Vaccination
                                        dao.insert(new Animal("Bella1846", "Goat", 6)); // Suggested: Regular health check
                                        dao.insert(new Animal("Jack1847", "Cow", 14)); // Suggested: Deworming
                                        dao.insert(new Animal("Buddy1848", "Goat", 8)); // Suggested: Regular health check
                                        dao.insert(new Animal("Luna1849", "Cat", 13)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Bella1850", "Cat", 7)); // Suggested: Vaccination
                                        dao.insert(new Animal("Luna1851", "Cow", 10)); // Suggested: Dental care
                                        dao.insert(new Animal("Molly1852", "Sheep", 7)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Daisy1853", "Goat", 2)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Buddy1854", "Cat", 4)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Daisy1855", "Cat", 14)); // Suggested: Neutering
                                        dao.insert(new Animal("Luna1856", "Dog", 7)); // Suggested: Deworming
                                        dao.insert(new Animal("Buddy1857", "Sheep", 4)); // Suggested: Dental care
                                        dao.insert(new Animal("Buddy1858", "Goat", 13)); // Suggested: Regular health check
                                        dao.insert(new Animal("Buddy1859", "Goat", 1)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Max1860", "Dog", 15)); // Suggested: Dental care
                                        dao.insert(new Animal("Molly1861", "Cow", 3)); // Suggested: Health Check
                                        dao.insert(new Animal("Bella1862", "Goat", 4)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Charlie1863", "Cat", 9)); // Suggested: Regular health check
                                        dao.insert(new Animal("Buddy1864", "Goat", 10)); // Suggested: Health Check
                                        dao.insert(new Animal("Luna1865", "Goat", 14)); // Suggested: Regular health check
                                        dao.insert(new Animal("Buddy1866", "Cat", 8)); // Suggested: Neutering
                                        dao.insert(new Animal("Daisy1867", "Goat", 12)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Bella1868", "Dog", 5)); // Suggested: Neutering
                                        dao.insert(new Animal("Bella1869", "Goat", 11)); // Suggested: Health Check
                                        dao.insert(new Animal("Rocky1870", "Dog", 13)); // Suggested: Health Check
                                        dao.insert(new Animal("Daisy1871", "Goat", 9)); // Suggested: Deworming
                                        dao.insert(new Animal("Daisy1872", "Cat", 10)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Max1873", "Sheep", 10)); // Suggested: Vaccination
                                        dao.insert(new Animal("Buddy1874", "Goat", 13)); // Suggested: Vaccination
                                        dao.insert(new Animal("Charlie1875", "Cat", 1)); // Suggested: Neutering
                                        dao.insert(new Animal("Max1876", "Cat", 9)); // Suggested: Vaccination
                                        dao.insert(new Animal("Molly1877", "Sheep", 1)); // Suggested: Dental care
                                        dao.insert(new Animal("Charlie1878", "Cow", 8)); // Suggested: Neutering
                                        dao.insert(new Animal("Daisy1879", "Cow", 7)); // Suggested: Health Check
                                        dao.insert(new Animal("Bella1880", "Sheep", 10)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Bella1881", "Cow", 11)); // Suggested: Health Check
                                        dao.insert(new Animal("Bella1882", "Dog", 8)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Daisy1883", "Goat", 6)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Luna1884", "Goat", 11)); // Suggested: Neutering
                                        dao.insert(new Animal("Lucy1885", "Sheep", 13)); // Suggested: Vaccination
                                        dao.insert(new Animal("Lucy1886", "Sheep", 15)); // Suggested: Vaccination
                                        dao.insert(new Animal("Max1887", "Cow", 7)); // Suggested: Deworming
                                        dao.insert(new Animal("Bella1888", "Cow", 4)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Luna1889", "Sheep", 6)); // Suggested: Health Check
                                        dao.insert(new Animal("Daisy1890", "Cat", 15)); // Suggested: Health Check
                                        dao.insert(new Animal("Molly1891", "Cat", 11)); // Suggested: Dental care
                                        dao.insert(new Animal("Daisy1892", "Goat", 1)); // Suggested: Neutering
                                        dao.insert(new Animal("Buddy1893", "Cow", 15)); // Suggested: Health Check
                                        dao.insert(new Animal("Luna1894", "Dog", 8)); // Suggested: Regular health check
                                        dao.insert(new Animal("Buddy1895", "Cat", 14)); // Suggested: Vaccination
                                        dao.insert(new Animal("Charlie1896", "Dog", 11)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Molly1897", "Sheep", 1)); // Suggested: Neutering
                                        dao.insert(new Animal("Daisy1898", "Goat", 14)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Max1899", "Sheep", 13)); // Suggested: Health Check
                                        dao.insert(new Animal("Buddy1900", "Sheep", 4)); // Suggested: Deworming
                                        dao.insert(new Animal("Lucy1901", "Cow", 12)); // Suggested: Deworming
                                        dao.insert(new Animal("Jack1902", "Goat", 1)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Bella1903", "Sheep", 11)); // Suggested: Health Check
                                        dao.insert(new Animal("Daisy1904", "Cat", 15)); // Suggested: Neutering
                                        dao.insert(new Animal("Molly1905", "Cow", 9)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Max1906", "Goat", 11)); // Suggested: Vaccination
                                        dao.insert(new Animal("Charlie1907", "Dog", 14)); // Suggested: Neutering
                                        dao.insert(new Animal("Jack1908", "Sheep", 6)); // Suggested: Vaccination
                                        dao.insert(new Animal("Daisy1909", "Dog", 11)); // Suggested: Dental care
                                        dao.insert(new Animal("Jack1910", "Cow", 1)); // Suggested: Health Check
                                        dao.insert(new Animal("Bella1911", "Goat", 6)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Bella1912", "Sheep", 4)); // Suggested: Health Check
                                        dao.insert(new Animal("Max1913", "Dog", 8)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Daisy1914", "Cow", 15)); // Suggested: Deworming
                                        dao.insert(new Animal("Bella1915", "Cat", 12)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Rocky1916", "Dog", 9)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Lucy1917", "Cat", 1)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Charlie1918", "Goat", 3)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Luna1919", "Dog", 8)); // Suggested: Health Check
                                        dao.insert(new Animal("Max1920", "Sheep", 5)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Rocky1921", "Cat", 9)); // Suggested: Health Check
                                        dao.insert(new Animal("Buddy1922", "Goat", 10)); // Suggested: Health Check
                                        dao.insert(new Animal("Lucy1923", "Cat", 1)); // Suggested: Health Check
                                        dao.insert(new Animal("Max1924", "Dog", 12)); // Suggested: Regular health check
                                        dao.insert(new Animal("Lucy1925", "Sheep", 15)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Luna1926", "Goat", 3)); // Suggested: Deworming
                                        dao.insert(new Animal("Charlie1927", "Cat", 14)); // Suggested: Vaccination
                                        dao.insert(new Animal("Buddy1928", "Cow", 5)); // Suggested: Regular health check
                                        dao.insert(new Animal("Bella1929", "Goat", 7)); // Suggested: Vaccination
                                        dao.insert(new Animal("Jack1930", "Sheep", 10)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Luna1931", "Dog", 5)); // Suggested: Neutering
                                        dao.insert(new Animal("Luna1932", "Goat", 7)); // Suggested: Deworming
                                        dao.insert(new Animal("Daisy1933", "Cow", 10)); // Suggested: Dental care
                                        dao.insert(new Animal("Rocky1934", "Dog", 9)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Rocky1935", "Goat", 3)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Bella1936", "Cat", 6)); // Suggested: Dental care
                                        dao.insert(new Animal("Charlie1937", "Sheep", 15)); // Suggested: Health Check
                                        dao.insert(new Animal("Max1938", "Cat", 14)); // Suggested: Health Check
                                        dao.insert(new Animal("Molly1939", "Goat", 3)); // Suggested: Regular health check
                                        dao.insert(new Animal("Max1940", "Cat", 12)); // Suggested: Health Check
                                        dao.insert(new Animal("Luna1941", "Sheep", 13)); // Suggested: Neutering
                                        dao.insert(new Animal("Molly1942", "Goat", 1)); // Suggested: Neutering
                                        dao.insert(new Animal("Daisy1943", "Cat", 9)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Jack1944", "Dog", 4)); // Suggested: Neutering
                                        dao.insert(new Animal("Rocky1945", "Cat", 10)); // Suggested: Health Check
                                        dao.insert(new Animal("Lucy1946", "Cat", 15)); // Suggested: Regular health check
                                        dao.insert(new Animal("Jack1947", "Cow", 12)); // Suggested: Health Check
                                        dao.insert(new Animal("Lucy1948", "Cow", 2)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Jack1949", "Sheep", 10)); // Suggested: Health Check
                                        dao.insert(new Animal("Jack1950", "Cow", 5)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Rocky1951", "Dog", 6)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Luna1952", "Dog", 6)); // Suggested: Dental care
                                        dao.insert(new Animal("Rocky1953", "Dog", 10)); // Suggested: Neutering
                                        dao.insert(new Animal("Rocky1954", "Sheep", 5)); // Suggested: Regular health check
                                        dao.insert(new Animal("Luna1955", "Dog", 3)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Bella1956", "Goat", 4)); // Suggested: Deworming
                                        dao.insert(new Animal("Lucy1957", "Cat", 7)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Daisy1958", "Sheep", 2)); // Suggested: Dental care
                                        dao.insert(new Animal("Molly1959", "Goat", 11)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Buddy1960", "Cat", 4)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Molly1961", "Dog", 4)); // Suggested: Health Check
                                        dao.insert(new Animal("Buddy1962", "Sheep", 14)); // Suggested: Neutering
                                        dao.insert(new Animal("Max1963", "Sheep", 6)); // Suggested: Neutering
                                        dao.insert(new Animal("Lucy1964", "Sheep", 4)); // Suggested: Vaccination
                                        dao.insert(new Animal("Max1965", "Goat", 9)); // Suggested: Vaccination
                                        dao.insert(new Animal("Buddy1966", "Cat", 13)); // Suggested: Health Check
                                        dao.insert(new Animal("Lucy1967", "Cat", 11)); // Suggested: Neutering
                                        dao.insert(new Animal("Daisy1968", "Cat", 9)); // Suggested: Regular health check
                                        dao.insert(new Animal("Molly1969", "Dog", 15)); // Suggested: Health Check
                                        dao.insert(new Animal("Luna1970", "Dog", 7)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Charlie1971", "Dog", 2)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Max1972", "Dog", 8)); // Suggested: Dental care
                                        dao.insert(new Animal("Jack1973", "Dog", 6)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Molly1974", "Cat", 6)); // Suggested: Neutering
                                        dao.insert(new Animal("Lucy1975", "Sheep", 15)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Max1976", "Cat", 14)); // Suggested: Health Check
                                        dao.insert(new Animal("Lucy1977", "Cow", 5)); // Suggested: Dental care
                                        dao.insert(new Animal("Buddy1978", "Goat", 9)); // Suggested: Vaccination
                                        dao.insert(new Animal("Max1979", "Dog", 14)); // Suggested: Neutering
                                        dao.insert(new Animal("Lucy1980", "Goat", 8)); // Suggested: Deworming
                                        dao.insert(new Animal("Jack1981", "Cat", 7)); // Suggested: Hoof Trimming
                                        dao.insert(new Animal("Charlie1982", "Cat", 1)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Max1983", "Cat", 15)); // Suggested: Health Check
                                        dao.insert(new Animal("Max1984", "Dog", 13)); // Suggested: Health Check
                                        dao.insert(new Animal("Lucy1985", "Goat", 12)); // Suggested: Dental care
                                        dao.insert(new Animal("Max1986", "Cat", 12)); // Suggested: Neutering
                                        dao.insert(new Animal("Lucy1987", "Sheep", 8)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Buddy1988", "Cat", 4)); // Suggested: Health Check
                                        dao.insert(new Animal("Lucy1989", "Cat", 8)); // Suggested: Skin treatment
                                        dao.insert(new Animal("Jack1990", "Cat", 13)); // Suggested: Health Check
                                        dao.insert(new Animal("Luna1991", "Dog", 6)); // Suggested: Diet consulting
                                        dao.insert(new Animal("Lucy1992", "Dog", 2)); // Suggested: Health Check
                                        dao.insert(new Animal("Luna1993", "Sheep", 1)); // Suggested: Neutering
                                        dao.insert(new Animal("Charlie1994", "Cat", 10)); // Suggested: Vaccination
                                        dao.insert(new Animal("Rocky1995", "Sheep", 11)); // Suggested: Dental care
                                        dao.insert(new Animal("Charlie1996", "Cow", 7)); // Suggested: Deworming
                                        dao.insert(new Animal("Lucy1997", "Cow", 4)); // Suggested: Health Check
                                        dao.insert(new Animal("Charlie1998", "Cat", 12)); // Suggested: Deworming
                                        dao.insert(new Animal("Buddy1999", "Goat", 8)); // Suggested: Deworming
                                    });
                                }
                            })
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}