-- điểm trung bình toàn trường
USE masterdev_tiencm8;

SELECT AVG(student_class.scoress) as scores_avg FROM student_class ;

-- tỷ lệ trượt , trung bình , khá , giỏi , xuất sắc
SELECT ((SELECT COUNT(*) FROM student_class  WHERE student_class.scoress < 4) / (SELECT COUNT(*) FROM student_class)*100) AS fail_ratio  ;

SELECT ((SELECT COUNT(*) FROM student_class WHERE student_class.scoress >= 4 AND student_class.scoress < 6) / (SELECT COUNT(*) FROM student_class)*100) AS medium_ratio;

SELECT ((SELECT COUNT(*) FROM student_class WHERE student_class.scoress >= 6 AND student_class.scoress < 8) / (SELECT COUNT(*) FROM student_class)*100) AS fairly_ratio;

SELECT ((SELECT COUNT(*) FROM student_class WHERE student_class.scoress >= 8 AND student_class.scoress < 9) / (SELECT COUNT(*) FROM student_class)*100) AS good_ratio;

SELECT ((SELECT COUNT(*) FROM student_class WHERE student_class.scoress >= 9) / (SELECT COUNT(*) FROM student_class)*100) AS excellent_ratio;


-- Môn nào có điểm trung bình cao nhất

SELECT sbj.subject_name, AVG(sc.scoress) AS max_avg_scores 
FROM subject sbj, student_class sc, class 
WHERE sbj.subject_id = class.subject_id 
AND class.class_id = sc.class_id 
GROUP BY sbj.subject_id 
ORDER BY AVG(sc.scoress) DESC
LIMIT 1;

-- Lớp nào có điểm trung bình cao nhất

SELECT sc.class_id , AVG(sc.scoress) AS max_avg_scores
FROM student_class sc
GROUP BY sc.class_id  
ORDER BY AVG(sc.scoress) DESC
LIMIT 1;


-- Bạn nào có điểm trung bình cao nhất 

SELECT st.full_name , AVG(sc.scoress) AS max_avg_scores
FROM student_class sc, student st
WHERE sc.student_id = st.student_id 
GROUP BY sc.student_id
ORDER BY AVG(sc.scoress) DESC 
LIMIT 1;

-- Môn nào có tỉ lệ trượt cao nhất

SELECT tmp1.subject_name , tmp2.c/tmp1.c*100 AS fail_ration 
FROM (
(SELECT sbj.subject_id , sbj.subject_name , COUNT(sbj.subject_id) AS c  
FROM student_class sc, class, subject sbj
WHERE sc.class_id = class.class_id AND class.subject_id = sbj.subject_id
GROUP BY sbj.subject_id) tmp1 
INNER JOIN 
(SELECT sbj.subject_id AS subject_id, sbj.subject_name AS subject_name, COUNT(sbj.subject_id) AS c
FROM student_class sc, class, subject sbj
WHERE sc.class_id = class.class_id AND class.subject_id = sbj.subject_id AND sc.scores < 4.0
GROUP BY sbj.subject_id) tmp2
ON tmp1.subject_id = tmp2.subject_id)
ORDER BY tmp2.c/tmp1.c DESC
LIMIT 1;

-- Danh sách các bạn không trượt môn nào? (không có bạn nào)
SELECT tmp1.full_name AS list_pass_all_student
FROM
(SELECT DISTINCT std.student_id AS student_id, std.full_name AS full_name 
FROM student std, student_class sc
WHERE std.student_id = sc.student_id) tmp1
LEFT JOIN
(SELECT DISTINCT std.student_id AS student_id, std.full_name AS full_name
FROM student std, student_class sc
WHERE std.student_id = sc.student_id AND sc.scores < 4.0) tmp2
ON tmp1.student_id = tmp2.student_id
WHERE tmp2.student_id IS NULL;

-- Top 10 môn học khó nhất

SELECT tmp1.subject_name AS subject_name, tmp2.c/tmp1.c * 100 AS fail_ration FROM (
(SELECT sbj.subject_id AS subject_id, sbj.subject_name AS subject_name, COUNT(sbj.subject_id) AS c  
FROM student_class sc, class, subject sbj
WHERE sc.class_id = class.class_id AND class.subject_id = sbj.subject_id
GROUP BY sbj.subject_id) tmp1 
INNER JOIN 
(SELECT sbj.subject_id AS subject_id, sbj.subject_name AS subject_name, COUNT(sbj.subject_id) AS c
FROM student_class sc, class, subject sbj
WHERE sc.class_id = class.class_id AND class.subject_id = sbj.subject_id AND sc.scores < 4.0
GROUP BY sbj.subject_id) tmp2
ON tmp1.subject_id = tmp2.subject_id)
ORDER BY tmp2.c/tmp1.c DESC
LIMIT 10;
