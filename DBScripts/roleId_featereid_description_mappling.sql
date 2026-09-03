
CREATE TABLE public.usos_role_mapping (
    role_id BIGINT PRIMARY KEY,
    user_type VARCHAR(30) NOT NULL,
    role_code VARCHAR(50) NOT NULL,
    role_name VARCHAR(100) NOT NULL,
    role_description TEXT NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);

INSERT INTO public.usos_role_mapping
(role_id, user_type, role_code, role_name, role_description)
VALUES
(1001, 'UNIVERSITY', 'UNIVERSITY_ADMIN', 'University Administrator',
 'Manages university-level configuration, colleges, users, roles and academic structure'),

(1002, 'UNIVERSITY', 'UNIVERSITY_PRINCIPAL', 'University Principal',
 'Manages university academic and administrative operations'),

(1003, 'COLLEGE', 'COLLEGE_PRINCIPAL', 'College Principal',
 'Manages college administration, teachers, staff and students'),

(1004, 'COLLEGE', 'COLLEGE_TEACHER', 'College Teacher',
 'Manages teaching activities, courses and student academic information'),

(1005, 'COLLEGE', 'COLLEGE_STAFF', 'College Staff',
 'Performs assigned administrative and operational activities'),

(1006, 'SCHOOL', 'SCHOOL_PRINCIPAL', 'School Principal',
 'Manages school administration, teachers, staff and students'),

(1007, 'SCHOOL', 'SCHOOL_TEACHER', 'School Teacher',
 'Manages classes, students, attendance and academic activities'),

(1008, 'SCHOOL', 'SCHOOL_STUDENT', 'School Student',
 'Accesses academic information, attendance, fees and other student services'),

(1009, 'SCHOOL', 'SCHOOL_STAFF', 'School Staff',
 'Performs assigned school administrative and operational activities');

CREATE TABLE public.usos_staff_type (
    staff_type_id BIGINT PRIMARY KEY,
    staff_type_code VARCHAR(50) NOT NULL UNIQUE,
    staff_type_name VARCHAR(100) NOT NULL,
    staff_description TEXT,
    is_active BOOLEAN NOT NULL DEFAULT TRUE
);

INSERT INTO public.usos_staff_type
(staff_type_id, staff_type_code, staff_type_name, staff_description)
VALUES
(2001, 'WATCHMAN', 'Watchman', 'Responsible for security and access monitoring'),
(2002, 'PEON', 'Peon', 'Provides general administrative support'),
(2003, 'CLEANER', 'Cleaner', 'Responsible for cleanliness and sanitation'),
(2004, 'DRIVER', 'Driver', 'Responsible for authorized transportation'),
(2005, 'RECEPTIONIST', 'Receptionist', 'Handles reception and visitor coordination'),
(2006, 'LIBRARIAN', 'Librarian', 'Manages library resources and services'),
(2007, 'ACCOUNTANT', 'Accountant', 'Manages financial and accounting activities');

CREATE TABLE public.usos_features (
    feature_id BIGINT PRIMARY KEY,
    feature_code VARCHAR(100) NOT NULL UNIQUE,
    feature_name VARCHAR(150) NOT NULL,
    feature_description TEXT,
    is_active BOOLEAN NOT NULL DEFAULT TRUE
);

INSERT INTO public.usos_features
(feature_id, feature_code, feature_name, feature_description)
VALUES
(3001, 'CREATE_COLLEGE', 'Create College',
 'Allows creation of a college under a university'),

(3002, 'MANAGE_COLLEGE', 'Manage College',
 'Allows management of college information'),

(3003, 'CREATE_TEACHER', 'Create Teacher',
 'Allows creation of teacher accounts'),

(3004, 'MANAGE_TEACHER', 'Manage Teacher',
 'Allows management of teacher information'),

(3005, 'CREATE_STUDENT', 'Create Student',
 'Allows creation of student accounts'),

(3006, 'MANAGE_STUDENT', 'Manage Student',
 'Allows management of student information'),

(3007, 'VIEW_ATTENDANCE', 'View Attendance',
 'Allows viewing attendance information'),

(3008, 'MANAGE_ATTENDANCE', 'Manage Attendance',
 'Allows creating and updating attendance'),

(3009, 'VIEW_FEES', 'View Fees',
 'Allows viewing fee information'),

(3010, 'MANAGE_FEES', 'Manage Fees',
 'Allows managing student fee information');