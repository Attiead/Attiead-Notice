package in.attiead.notice.adapter.in.web;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.attiead.notice.adapter.in.dto.NoticeCreateRequestDTO;
import in.attiead.notice.adapter.in.dto.NoticeInfoResponseDTO;
import in.attiead.notice.application.port.in.NoticeCreateUseCase;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(NoticeCreateController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
class NoticeCreateControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @MockBean
  NoticeCreateUseCase noticeCreateUseCase;

  private NoticeCreateRequestDTO createNoticeRequest() {
    return NoticeCreateRequestDTO.builder().title("테스트제목").content("테스트 공지사항 내용-1")
        .author("테스트 공지사항 작성자-1").build();
  }

  private NoticeInfoResponseDTO getNoticeInfo() {
    return NoticeInfoResponseDTO.builder().title("테스트제목").content("테스트 공지사항 내용-1")
        .author("테스트 공지사항 작성자-1").build();
  }

  private List<MockMultipartFile> generateMultipartFile(String contentType) {
    String fileExtension = switch (contentType) {
      case "application/pdf" -> ".pdf";
      case "image/jpeg" -> ".jpg";
      case "application/msword" -> ".doc";
      case "application/vnd.ms-excel" -> ".xls";
      default -> throw new IllegalArgumentException("Unsupported content type: " + contentType);
    };

    Random random = new Random();
    int fileCnt = random.nextInt(3);

    return IntStream.range(0, fileCnt).mapToObj(inx -> {
      String name = "mock file " + inx;
      String originalFileName = "originalFileName" + inx + fileExtension;
      byte[] content = ("This is the content of the file " + inx).getBytes();
      return new MockMultipartFile(name, originalFileName, contentType, content);
    }).toList();
  }

  @Test
  @DisplayName("Notice 생성 테스트")
  void createNotice() throws Exception {
    //given (준비단계)
    NoticeCreateRequestDTO requestDTO = createNoticeRequest();
    byte[] requestByteDTO = objectMapper.writeValueAsBytes(requestDTO);
    MockMultipartFile requestCreateDTOFile = new MockMultipartFile(
        "noticeCreateRequestDto",
        "noticeCreateRequestDTO",
        "Application/json",
        requestByteDTO
    );
    List<MockMultipartFile> mockMultipartFiles = generateMultipartFile("application/pdf");
    NoticeInfoResponseDTO responseDTO = getNoticeInfo();

    // 가짜 객체에 대한 행동 정의

    //When (실행 단계)
    /**
     * ResultAction 객체 :  HTTP 요청에 대한 응답을 검증하는 데 사용
     * RestDocumentationRequestBuilders
     * 목적: RestDocumentationRequestBuilders는 MockMvcRequestBuilders의 기능을 확장하여,
     * Spring REST Docs를 사용하여 API 문서를 자동으로 생성하는 데 필요한 추가 정보를 제공합니다.
     * 기능: MockMvcRequestBuilders의 모든 기능을 포함하며, 추가적으로 REST Docs에 필요한 문서화 과정을 지원합니다.
     * 예를 들어, 요청 경로의 파라미터, 응답 필드 등을 문서화하는 데 필요한 정보를 추가할 수 있습니다.
     *
     * content()
     * - String을 사용하는 경우
     *
     * 사용 상황: 주로 JSON 또는 XML과 같은 텍스트 기반의 데이터를 요청 본문으로 보낼 때 사용합니다.
     * 목적: 요청 본문에 포함될 데이터를 문자열 형태로 제공합니다. 예를 들어, JSON 형태의 데이터를 직렬화하여 문자열로 변환한 후 이를 요청 본문으로 설정할 수 있습니다.
     * 예시: .content("{\"name\": \"John\", \"age\": 30}") (JSON 데이터를 문자열로 표현)
     * - byte[]를 사용하는 경우
     *
     * 사용 상황: 주로 바이너리 데이터를 요청 본문으로 보낼 때 사용합니다. 예를 들어, 파일 업로드나 이미지와 같은 바이너리 데이터를 전송할 때 사용될 수 있습니다.
     * 목적: 요청 본문에 포함될 데이터를 바이트 배열로 제공합니다. 이는 텍스트 기반 데이터보다 낮은 수준의 데이터 표현이며, 파일이나 이미지와 같은 비텍스트 데이터를 전송하는 데 적합합니다.
     * 예시: .content(imageBytes) (이미지 데이터를 바이트 배열로 변환한 것)
     *
     *     RestDocumentationRequestBuilders.multipart("/api/v1/notices")
     *         .file(requestCreateDTOFile)
     *         .file(mockMultipartFiles)
     *         .contentType(MediaType.MULTIPART_FORM_DATA);
     *
     */
    MockMultipartHttpServletRequestBuilder requestCreateDTOBuilder = multipart("/api/v1/notices")
        .file(requestCreateDTOFile);
    Optional.ofNullable(mockMultipartFiles)
        .ifPresent(file -> file.forEach(requestCreateDTOBuilder::file));
    requestCreateDTOBuilder.contentType(MediaType.MULTIPART_FORM_DATA);

    ResultActions testActions = mockMvc.perform(requestCreateDTOBuilder)
        .andDo(print());

    //Then (검증 단계)
    testActions.andExpect(status().isOk())
        .andDo(document("noticeCreate-documentation"));
  }
}
