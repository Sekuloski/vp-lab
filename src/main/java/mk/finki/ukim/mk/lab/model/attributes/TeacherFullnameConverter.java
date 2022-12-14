package mk.finki.ukim.mk.lab.model.attributes;

import jakarta.persistence.AttributeConverter;

public class TeacherFullnameConverter implements AttributeConverter<TeacherFullname, String> {

        private static final String SEPARATOR = ", ";

        @Override
        public String convertToDatabaseColumn(TeacherFullname fullname) {
            if (fullname == null) {
                return null;
            }

            StringBuilder sb = new StringBuilder();
            if (fullname.getSurname() != null && !fullname.getSurname()
                    .isEmpty()) {
                sb.append(fullname.getSurname());
                sb.append(SEPARATOR);
            }

            if (fullname.getName() != null
                    && !fullname.getName().isEmpty()) {
                sb.append(fullname.getName());
            }

            return sb.toString();
        }

        @Override
        public TeacherFullname convertToEntityAttribute(String dbTeacherFullName) {
            if (dbTeacherFullName == null || dbTeacherFullName.isEmpty()) {
                return null;
            }

            String[] pieces = dbTeacherFullName.split(SEPARATOR);

            if (pieces == null || pieces.length == 0) {
                return null;
            }

            TeacherFullname personName = new TeacherFullname();
            String firstPiece = !pieces[0].isEmpty() ? pieces[0] : null;
            if (dbTeacherFullName.contains(SEPARATOR)) {
                personName.setSurname(firstPiece);

                if (pieces.length >= 2 && pieces[1] != null
                        && !pieces[1].isEmpty()) {
                    personName.setName(pieces[1]);
                }
            } else {
                personName.setName(firstPiece);
            }

            return personName;
        }
}