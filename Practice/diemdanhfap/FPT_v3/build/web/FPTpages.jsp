<%-- 
    Document   : FPTpages
    Created on : Oct 16, 2022, 1:40:22 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.util.ArrayList"%> 
<%@page import ="model.User"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>

        <div class="row">
            <div class ="col-md-1"></div>
            <div class="col-md-7">

                <h1><span>FPT University Academic Portal</span>
                </h1>

            </div>
            <div class="col-md-4">
                <table>
                    <tbody><tr>
                            <td colspan="2" class="auto-style1"><strong>FAP mobile app (myFAP) is ready at</strong></td>

                        </tr>
                        <tr>
                            <td><a href="https://apps.apple.com/app/id1527723314">
                                    <img src='img/appStore.jpg' style="width: 120px; height: 40px" alt="apple store"></a></td>
                            <td><a href="https://play.google.com/store/apps/details?id=com.fuct">
                                    <img src='img/GoogleStore.jpg' style="width: 120px; height: 40px" alt="google store"></a></td>

                        </tr>
                    </tbody></table>
            </div>
        </div>



        <div class="row">
            <div class="col-md-1"></div>
            <div class="col-md-9" style="background-color: #f7f6f9 ; padding: 30px ">
                
                <div style="float: right">
                    <table >
                        <button  type="button" class="btn btn-success h-15 pt-0 me-1 ms-1 mt-1"  style="height: 20px; ;font-size: 12px; background-color: rgb(92,184,92);">  <a href="Detail.jsp"  target="target" style="color: white" > ${studentId} </a> </button>|
                        <button  type="button" class="btn btn-success h-15 pt-0 me-1 ms-1 mt-1" style="height: 20px; ;font-size: 12px; background-color: rgb(92,184,92);">  <a href="index.html" target="target" style="color: white">Logout </a></button>|
                        <button  type="button" class="btn btn-success h-15 pt-0 me-1 ms-1 mt-1" style="height: 20px; ;font-size: 12px; background-color: rgb(92,184,92);">  <a style="color: white">${campus} </a> </button>
                    </table>
                </div>


            </div>
            <div class="col-md-2"></div>
        </div>



        <div class="row" style="margin-top: 50px">
            <div class ="col-md-1"></div>

            <div class ="col-md-5">
                <div style="border: solid 1px #ccc; height: 100%; width: 400px; box-shadow: 2px 2px buttonface">
                    <div style="background-color: rgb(14,101,181); width: 45%; padding-top: 1px; border-top-left-radius: 5px; border-top-right-radius: 5px; margin-top: -10px; margin-left: 0px;">
                        <h3 style="font-family:Arial, Helvetica, sans-serif ; color: white; text-align: center;">News</h3>
                    </div>
                    <br><!-- comment -->
                    <br>
                    <div style="display: flex">
                        <p style=" font-weight: bold" >Tin Tức<p>
                            <button type="button" style="background-color: rgb(239,169,68); color: white; border-color: white; border-radius: 5px; padding: 4px; margin-top: -4px">xem tại đây</button>
                    </div>
                    <div class="col-md-12">
                        <table style="margin-left: 20px; margin-right: -13px; margin-top: 50px; margin-bottom: 30px; " class="tableStyle" border="1">
                            <tr >
                                <td id="color_td" colspan="2"> <div style="color: white; background-color: rgb(0,153,0); margin: 10px; font-size: 20px;">IMPORTANT  NOTICE </div></td>
                            </tr>
                            <tr >
                                <td id="color_td" style="background-color: rgb(51,102,204); color: white; text-align: center; font-family: Arial, Helvetica, sans-serif; font-size: 15px; padding-top: 3px; padding-bottom: 3px;">Type of procedure |<br> Loại thủ tục </td>
                                <td id="color_td" style="background-color: rgb(51,102,204); color: white; text-align: center; font-family: Arial, Helvetica, sans-serif; font-size: 15px; padding-top: 3px; padding-bottom: 3px">Deadline |<br> Hạn nộp Đơn</td>
                            </tr>
                            <tr>
                                <td id="color_td"><span style="color: rgb(47,122,195);">1. Changing major</span> (Chuyển ngành) </td>
                                <td rowspan="2" id="color_td" style="margin-top: -100px;"> <span><span style="color: rgb(47,122,195);">4 weeks before the new semester</span> (4 tuần  trước học kỳ mới)</span></td>
                            </tr>
                            <tr>
                                <td id="color_td"><span style="color: rgb(47,122,195);">2. Changing campus</span> (Chuyển cơ sở) </td>
                            </tr>
                            <tr >
                                <td id="color_td"><span style="color: rgb(47,122,195);">3. Rejoin (Nhập học trở lại)</span></td>
                                <td id="color_td"><span style="color: rgb(47,122,195);">10 days before the new semester</span> (10 ngày trước học kỳ mới)</td>
                            </tr>
                            <tr >
                                <td id="color_td"><br></td>
                                <td id="color_td"><br></td>
                            </tr>
                            <tr>
                                <td id="color_td"><span style="color: rgb(47,122,195);">4. Suspend one semester</span> (Bảo lưu học kỳ)
                                <td rowspan="8" id="color_td"><span style="color: rgb(47,122,195);">1 week before the new semester</span> (1 tuần trước học kỳ mới)</td>
                            </tr>
                            <tr>
                                <td id="color_td"><span style="color: rgb(47,122,195);">5. Suspend one semester to take repeated course</span> (Tạm ngưng  tiến độ 1 học kỳ để học lại)</td>
                            </tr>
                            <tr>
                                <td id="color_td"><span style="color: rgb(47,122,195);">6. Suspend subject</span> (Tạm ngừng môn) </td>
                            </tr>
                            <tr>
                                <td id="color_td"><span style="color: rgb(47,122,195);">7. Register to repeat a course</span> (Đăng ký học lại)</td>
                            </tr>
                            <tr>
                                <td id="color_td"><span style="color: rgb(47,122,195);">8. Register extra courses</span> (Đăng ký học đi chậm kỳ) </td>
                            </tr>
                            <tr>
                                <td id="color_td"><span style="color: rgb(47,122,195);">9. Register to improve mark</span> (Đăng ký học cải thiện) </td>
                            </tr>
                            <tr>
                                <td id="color_td"><span style="color: rgb(47,122,195);">10. Move out class</span> (Chuyển lớp) </td>
                            </tr>
                            <tr>
                                <td id="color_td"><span style="color: rgb(47,122,195);">11. Request a drop out</span> (Thôi học tự nguyện) </td>
                            </tr>
                            <tr >
                                <td id="color_td"><br></td>
                                <td id="color_td"><br></td>
                            </tr>
                            <tr >
                                <td id="color_td"><span style="color: rgb(47,122,195);">12. Retake to improve mark</span> (Thi cải thiện)</td>
                                <td id="color_td"><span style="color: rgb(47,122,195);">12 hours before the final exam resit</span> (12h trước lịch thi lại)</td>
                            </tr>
                            <tr >
                                <td id="color_td"><span style="color: rgb(47,122,195);">13. Re – Examination</span> (Phúc tra)</td>
                                <td id="color_td"><span style="color: rgb(47,122,195);">1 week after the  examination result public</span> (1 tuần sau ngày công bố kết qủa)</td>
                            </tr>
                            <tr >
                                <td id="color_td"><span style="color: rgb(47,122,195);">14. Free of attendance</span> (Miễn điểm danh)</td>
                                <td id="color_td"><span style="color: rgb(47,122,195);">2 weeks after starting the new semester</span> (2 tuần sau khi học kỳ mới bắt đầu)</td>
                            </tr>
                            <tr >
                                <td id="color_td"><span style="color: rgb(47,122,195);">15. Pay specialized tuition</span> (Nộp học phí chuyên ngành)</td>
                                <td id="color_td"><span style="color: rgb(47,122,195);">7 working days before the new semester</span> (7 ngày trước học kỳ học mới không tính T7, CN)</td>
                            </tr>
                            <tr >
                                <td id="color_td"><span style="color: rgb(47,122,195);">16. Pay preparetation English tuition</span> (Nộp học phí Tiếng Anh dự bị)</td>
                                <td id="color_td"><span style="color: rgb(47,122,195);">3 working days before the new course</span> (3 ngày trước khi bắt đầu khóa học không tính T7, CN)</td>
                            </tr>
                        </table>
                    </div>
                </div><!-- comment -->
            </div>

            <div class ="col-md-4">
                <div style="border: solid 1px #ccc; height: 100%; width: 640px; margin-left:-170px ">
                    <div style="background-color: rgb(244,153,12); width: 45%; padding-top: 1px; border-top-left-radius: 5px; border-top-right-radius: 5px; margin-top: -10px; margin-left: 0px;">
                        <h3 style="font-family:Arial, Helvetica, sans-serif ; color: white; text-align: center;">Academic Information</h3>
                    </div>
                    <br>
                    <table class="table  table-borderless" >
                        <tr>
                            <th>Registration/Application(Thủ tục/đơn từ)</th>
                            <th>Information Access(Tra cứu thông tin)</th>
                        </tr>
                        <tr>
                            <td style="width: 55%" >
                                <ul>
                                    <li><a href="">Suspend one semester to take repeated course</a>&nbsp;|&nbsp; <a >Cancel</a> (Xin tạm hoãn tiến độ một học kỳ
                                        để học lại | Hủy bỏ việc xin tạm hoãn)</li>
                                    <li><a href="">Suspend one semester</a>&nbsp;|&nbsp;
                                        <a href="">Cancel</a> (Xin tạm nghỉ một học kỳ | Hủy bỏ việc xin tạm nghỉ)</li>
                                    <li><a href="">Move out class </a>(Xin chuyển lớp)</li>
                                    <li><a href="">Register extra courses</a> (Đăng ký môn học đi chậm kỳ)</li>
                                    <li><a href="">Register to improve mark </a>&nbsp;(Đăng ký học cải thiện điểm)</li>
                                    <li><a href="">Register to repeat a course</a> (Đăng ký học lại)</li>
                                    <li><a href="">Cancel registration </a>(Hủy đăng ký học)</li>
                                    <li><a href="">Register Free Elective Courses </a>(Đăng ký môn tự chọn)</li>
                                    <li><a href="">Send Application</a> (Gửi đơn) |&nbsp;<a href="">View Application</a> (Xem đơn)</li>
                                    <li><a href="">Xin xác nhận sinh viên</a></li>
                                    <li><a href="">Choose paid items (Lựa chọn các khoản nộp)</a> - <a href="">View</a></li>
                                    <li><a href="">Yêu cầu đổi chéo lớp với sinh viên </a></li>




                                </ul>

                            </td>
                            <td>
                                <ul>
                                    <li><a href="">University timetable </a>(Lịch học)</li>
                                    <li><a href="fee">Tuition fee per course</a> (Biểu học phí)</li>
                                    <li><a href="TableTime">Weekly timetable</a> (Thời khóa biểu từng tuần)</li>
                                    <li><a href="">Blended Online Course (BLOC) Schedules </a>(Lịch học các môn theo phương pháp BLOC trong kỳ)</li>
                                    <li><a href="">Class timetable</a> (Xem thời khóa biểu của một lớp)</li>
                                    <li><a href="" target="_blank">View exam schedule </a>(Xem lịch thi)

                                        <span id="ctl00_mainContent_lnkhocphi"></span>
                                    <li><a href="" target="_blank">View Syllabuses</a>(Xem đề cương môn học)</li>

                                    <li><a href="" target="_blank">EduNext student guideline</a></li>

                                    <li><a href="" target="_blank">Help/Hỗ trợ</a></li>

                                    <span id="ctl00_mainContent_lblOR"><li><a href="" target="_blank">Tài liệu hướng dẫn: Định hướng cho sinh viên</a></li></span>
                                </ul>

                            </td>

                        </tr>

                        <tr>
                            <td valign="top">
                                <h4>Feedback(Ý kiến)</h4>
                                <ul>
                                    <li><a href="">Feedback about teaching</a> (Ý kiến về việc giảng dạy)</li>
                                </ul>

                            </td>
                            <td valign="top">
                                <h4>Reports(Báo cáo)</h4>
                                <ul>
                                    <li><a href="attendance?id=${studentId}">Attendance report</a> (Báo cáo điểm danh)</li>
                                    <li><a href="">Mark Report</a> (Báo cáo điểm)</li>
                                    <li><a href="">Academic Transcript</a> (Báo cáo điểm)</li>
                                    <li><a href="">Curriculum</a> (Khung chương trình)</li>
                                    <li><a href="">Student Fee</a> (Tra cứu học phí đã nộp theo kỳ)</li>
                                    <li><a href="">Transaction history</a> (Lịch sử giao dịch)</li>
                                </ul>
                            </td>
                        </tr>
                        <tr>
                            <td valign="top">
                                <h4>Others(Khác)</h4>
                                <ul>

                                    <li><a href="">Student Profile</a>| <a href="">Update Profile</a></li>

                                    <li><a href="">View semester</a>, <a href="">room</a> ( Xem thông tin về học kỳ, phòng)</li>
                                    <li><a href="">Công nhận và chuyển đổi tín chỉ các học phần của Đại học trực tuyến (FUNiX)</a></li>

                                    <li><a href="">Danh sách các môn học lại chờ xếp lớp</a></li>
                                    <li><a href="">Các loại chứng chỉ</a></li>
                                    <li><a href="">Report điểm phong trào</a></li>


                                </ul>
                            </td>
                            <td>
                                <h4>Regulations(Các quy định)</h4>
                                <ul>
                                    <li><a href="" target="_blank">Regulations...</a></li>
                                    <li><a href="" target="_blank">Dormitory regulations (Nội quy KTX)</a></li>


                                </ul>
                            </td>

                        </tr>
                        <tr>
                            <td>
                                <h4>Courses on FPTU-Coursera</h4>
                                <ul>
                                    <li><a href="" target="_blank">Announcement</a></li>
                                </ul>
                                <ul>
                                    <li><a href="" target="_blank">Ask mentor</a></li>
                                </ul>
                                <ul>
                                    <li><a href="" target="_blank">View answer</a></li>
                                </ul>
                                <ul>
                                    <li><a href="" target="_blank">Submit certificates</a></li>
                                </ul>
                                <ul>
                                    <li><a href="" target="_blank">Certificate submission guideline</a></li>
                                </ul>
                            </td>
                            <td>
                                <div id="ctl00_mainContent_divKTX" class="row">
                                    <div class="panel-group">
                                        <div class="panel panel-default">
                                            <div class="panel-heading">Thông tin KTX </div>
                                            <div class="panel-body">
                                                <div id="ctl00_mainContent_divContent"><a href="">Thông tin KTX =&gt;Hòa Lạc - On Campus Dormitory</a></div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </td>
                        </tr>
                    </table>
                </div>


                <table width="100%" style="border: 1px solid transparent; margin: auto" id="cssTable">

                    <tbody><tr>
                            <td>
                                <div id="ctl00_divSupport">
                                    <br>
                                    <b>Mọi góp ý, thắc mắc xin liên hệ: </b><span style="color: rgb(34, 34, 34); font-family: arial, sans-serif; font-size: 13.333333969116211px; font-style: normal; font-variant: normal; font-weight: normal; letter-spacing: normal; line-height: normal;  text-align: start; text-indent: 0px; text-transform: none; widows: auto; word-spacing: 0px; background-color: rgb(255, 255, 255); display: inline !important; float: none;">Phòng dịch vụ sinh viên</span>: Email: <a href="mailto:dichvusinhvien@fe.edu.vn">dichvusinhvien@fe.edu.vn</a>.
                                    Điện thoại: <span class="style1" style="color: rgb(34, 34, 34); font-family: arial, sans-serif; font-size: 13.333333969116211px; font-style: normal; font-variant: normal; letter-spacing: normal; line-height: normal; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; widows: auto; background-color: rgb(255, 255, 255); display: inline !important; float: none;">(024)7308.13.13 </span>
                                    <br>
                                </div>
                            </td>

                        </tr>
                        <tr>
                            <td>
                                <p style="text-align: center">
                                    © Powered by <a href="http://fpt.edu.vn/" target="_blank">FPT University</a>&nbsp;|&nbsp;
                                    <a href="http://cms.fpt.edu.vn/" target="_blank">CMS</a>&nbsp;|&nbsp; <a href="http://library.fpt.edu.vn/" target="_blank">library</a>&nbsp;|&nbsp; <a href="http://library.books24x7.com/" target="_blank">books24x7</a>
                                    <span id="ctl00_lblHelpdesk"></span>
                                </p>
                            </td>
                        </tr>
                    </tbody></table>


                </body>
                </html>
